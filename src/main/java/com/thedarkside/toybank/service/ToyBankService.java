package com.thedarkside.toybank.service;

import com.thedarkside.toybank.exception.*;
import com.thedarkside.toybank.model.*;
import com.thedarkside.toybank.model.Error;
import com.thedarkside.toybank.repository.PaymentRepository;
import com.thedarkside.toybank.utils.ValidationUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ToyBankService {

    static final String DOC_URL = "https://thedarkside.io/docs/error-codes";

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    IdempotentUtils idempotentUtils;

    ValidationUtil validationUtil = new ValidationUtil();

    @Value("${idempotency.service.url:}")
    String idempotencyServiceUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public PaymentOriginationResponse createOutboundPayment(OutboundPaymentRequest outboundPaymentRequest, String idempotencyKey, boolean isDebugEnabled) throws Exception {
        PaymentOriginationResponse originationResponse = null;
        PaymentDB paymentDB;
        ObjectMapper objectMapper = new ObjectMapper();
   
        String paymentId = UUID.randomUUID().toString();

        String idResponse = getIdempotentRequestResponse(idempotencyKey);
        log.info("idResponse : {}", idResponse);

        if (StringUtils.hasText(idResponse)) {
            originationResponse = objectMapper.readValue(idResponse, PaymentOriginationResponse.class);
            log.info("OriginationResponse : {}", originationResponse);
            return originationResponse;
        }

        // if the provided payment date is null, setting the current local date.
        if (outboundPaymentRequest.getPaymentDate() == null
                || outboundPaymentRequest.getPaymentDate().isEmpty()) {
                    outboundPaymentRequest.setPaymentDate(getCurrentDate());
        }

        HttpStatus remoteResponse = null;
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String originalPaymentRequestString = objectMapper.writeValueAsString(outboundPaymentRequest);

        try {
            if (isBookTransferPayment(outboundPaymentRequest.getOriginatingAccount().getBank(), 
                    outboundPaymentRequest.getCounterpartyAccount().getBank())) {
                remoteResponse = initiateBookTransferPayment(outboundPaymentRequest);

            } else {
                remoteResponse = HttpStatus.OK;
            }

            if (remoteResponse != null) {
                PaymentStatus paymentStatus = createPaymentStatus(remoteResponse);
                originationResponse = new PaymentOriginationResponse(paymentId, idempotencyKey, paymentStatus);
                log.info("OriginationResponse {}", originationResponse);

                // Save to cache
                idempotentUtils.saveCache(idempotencyKey, "POST", "/payments", objectMapper
                        .writeValueAsString(outboundPaymentRequest), objectMapper.writeValueAsString(originationResponse));

                paymentDB = new PaymentDB(paymentId, "platformId",
                        paymentStatus.getStatus(), outboundPaymentRequest, PaymentRail.SECRET,
                        PaymentDirection.OUTBOUND, getCreationDate(), outboundPaymentRequest.getAmount());
                savePaymentDetails(paymentDB);
            }
        } catch (Exception exception) {
            log.error("Outbound Payment processing failed with request : {}", outboundPaymentRequest, exception);
            String exceptionMsg = exception.getMessage() != null ? exception.getMessage() : exception.getCause().getMessage();
            String msg = "Outbound Payment processing failure reason: ".concat(exceptionMsg);
            throwException(isDebugEnabled, new OutboundPaymentException(msg), new OutboundExceptionWithReq(msg, originalPaymentRequestString));
        }

        return originationResponse;
    }

    private String getCreationDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss Z");
        return dateFormat.format(new Date());
    }

    private PaymentStatus createPaymentStatus(HttpStatus httpStatus) {
        if (httpStatus.is2xxSuccessful()) {
            return PaymentStatus.builder()
                    .status(Status.CREATED)
                    .build();
        } else {
            return PaymentStatus.builder()
                    .status(Status.REJECTED)
                    .build();
        }
    }

    private HttpStatus initiateBookTransferPayment(OutboundPaymentRequest outboundPaymentRequest) throws OutboundProcessingFailedException {
        HttpStatus response = HttpStatus.BAD_REQUEST;

        if (outboundPaymentRequest != null) {
            log.info("Performing book transfer from account {} to account {}", 
                        outboundPaymentRequest.getOriginatingAccount().getAccountNumber(), 
                        outboundPaymentRequest.getCounterpartyAccount().getAccountNumber());
            response = HttpStatus.OK;
        } else {
            log.error("Book transfer request payload is null");
            throw new OutboundProcessingFailedException("Book transfer request payload is null");
        }

        return response;
    }

    private boolean isBookTransferPayment(Bank originatingBank, Bank counterPartyBank) {
        return originatingBank.getRoutingNumber() != null && counterPartyBank.getRoutingNumber() != null
                && originatingBank.getRoutingNumber().equals(counterPartyBank.getRoutingNumber());
    }

    private void throwException(boolean isDebugEnabled, Exception e1, Exception e2) throws Exception {
        if (!isDebugEnabled) {
            log.info(":::throw exception msg:::");
            throw e1;
        } else {
            log.info(":::throw exception msg with request:::");
            throw e2;
        }
    }

    private void savePaymentDetails(PaymentDB paymentDB) {
        paymentRepository.insert(paymentDB);
    }

    private String getCurrentDate() {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        log.info("effective date: {}", date);
        return date;
    }

    private List<Error> getErrorList(String errorMessage, String errorCode) {
        List<Error> errorList = new ArrayList<>();
        Error error = new Error(errorCode, DOC_URL, errorMessage);
        error.setIdempotencyKey(MDC.get("IDEMPOTENCY_KEY"));
        error.setPaymentId(MDC.get("PAYMENT_ID"));
        errorList.add(error);
        return errorList;
    }

    private String getIdempotentRequestResponse(String idempotencykey) {
        // make a REST call to Idempotency Service
        String idempotentResponse = "";
        try {
            ResponseEntity<String> idempotentRequestResponse = restTemplate()
                    .getForEntity(idempotencyServiceUrl + "/" + idempotencykey, String.class);

            if (idempotentRequestResponse.getStatusCode().is2xxSuccessful()) {
                idempotentResponse = idempotentRequestResponse.getBody();
            }
        } catch (HttpClientErrorException hcee) {
            log.error("{} {} {}", hcee.getStatusCode(), hcee.getCause(), hcee.getMessage());
        }
        catch (Exception e) {
            log.error("getIdempotentRequestResponse failed with reason: {}", e.getMessage());
        }
        return idempotentResponse;
    }

    private PaymentDB getPaymentIdsFromDB(String paymentId, String platformId) {
        Optional<PaymentDB> paymentDB = paymentRepository.findById(paymentId);

        PaymentDB payment = null;

        if (paymentDB.isPresent()) {
            payment = paymentDB.get();
        }

        return payment;
    }

    /**
     * Get List of Payment Details by PaymentId.
     */
    public GetPaymentDetailsResponse retrievePaymentDetailsByID(String paymentId, String platformId) throws OutboundProcessingFailedException, UnauthorizedClientException {
        PaymentDB paymentDB = getPaymentIdsFromDB(paymentId, platformId);

        GetPaymentDetailsResponse getPaymentDetailsResponse = null;

        if (paymentDB != null) {
            if (paymentDB.getRequestPayload() != null) {
                ModelMapper modelMapper = new ModelMapper();
                try {
                    getPaymentDetailsResponse = modelMapper.map(paymentDB.getRequestPayload(), GetPaymentDetailsResponse.class);
                    getPaymentDetailsResponse.setId(paymentDB.getId());
                } catch (Exception e) {
                    log.error("Not able to payment detail from repo to gatpaymentDetails response.", e);
                }
            }
        }
        return getPaymentDetailsResponse;
    }

    private void updateDetailsInDB(PaymentDB paymentDB) {
        paymentRepository.save(paymentDB);
    }

    public List<GetAllPaymentsResponse> retrievePaymentsByPlatformID(String platformId) {
        List<PaymentDB> paymentDBList = paymentRepository.findByPlatformId(platformId, Sort.by(Sort.Direction.DESC, "createdDateTime"));
        if (paymentDBList != null && !paymentDBList.isEmpty()) {
            return paymentDBList.stream().map(paymentDB -> new GetAllPaymentsResponse(
                    paymentDB.getId(), paymentDB.getPaymentRail(), paymentDB.getPaymentDirection(), paymentDB.getCreatedDateTime(),
                    paymentDB.getAmount())).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
