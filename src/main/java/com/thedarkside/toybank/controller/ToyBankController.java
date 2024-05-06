package com.thedarkside.toybank.controller;

import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;

import org.slf4j.MDC;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.thedarkside.toybank.exception.BusinessRuleValidationFailedException;
import com.thedarkside.toybank.exception.OutboundPaymentException;
import com.thedarkside.toybank.exception.OutboundProcessingRejectedException;
import com.thedarkside.toybank.exception.PaymentDetailsNotFoundException;
import com.thedarkside.toybank.model.*;
import com.thedarkside.toybank.service.ToyBankService;
import com.thedarkside.toybank.utils.ValidationUtil;

/**
 * ToyBankController
 *
 */
@RestController
@Slf4j
public class ToyBankController {

    @Autowired
    ToyBankService bankService;

    String idempotencyKey = "";
    String platformId = "";

    static final String IDEMPOTENCY_KEY = "IDEMPOTENCY_KEY";
    static final String PAYMENT_ID = "PAYMENT_ID";

    @SneakyThrows
    @PostMapping(path = "/payments")
    public ResponseEntity<PaymentOriginationResponse> createOutboundPayment(@Valid @RequestBody OutboundPaymentRequest outboundPaymentRequest,
                                                                 @RequestHeader Map<String, String> headers) {

        log.info("{} | Headers: {}", outboundPaymentRequest, headers);

        idempotencyKey = validateIdempotencyHeader(headers);
        ValidationUtil validationUtil = new ValidationUtil();

        MDC.put(IDEMPOTENCY_KEY, idempotencyKey);
        try {
            validationUtil.validatePaymentRequest(outboundPaymentRequest);
        } catch (BusinessRuleValidationFailedException e) {
            log.error("Outbound Payment Request validation failed with Reason, Request: {}", outboundPaymentRequest, e);
            throw new OutboundProcessingRejectedException("Rejected Outbound Payment request. Reason: ".concat(e.getMessage()));
        }

        PaymentOriginationResponse response = bankService.createOutboundPayment(outboundPaymentRequest, idempotencyKey, getXDebugEnabledHeaderVal(headers));
        log.info("Response: {}", response);

        if (response == null) {
            throw new OutboundPaymentException("Outbound Payment processing failed.");
        }
        
        MDC.put(PAYMENT_ID, response.getPaymentId());
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.CREATED);
    }

    @SneakyThrows
    @GetMapping(path = "/payments")
    public ResponseEntity<List<GetAllPaymentsResponse>> getAllPayments(@RequestHeader Map<String, String> headers) {
        platformId = validateClientHeader(headers);

        List<GetAllPaymentsResponse> getAllPayments = bankService.retrievePaymentsByPlatformID(platformId);
        if (!getAllPayments.isEmpty()) {
            return new ResponseEntity<>(getAllPayments, new HttpHeaders(), HttpStatus.OK);
        }
        throw new PaymentDetailsNotFoundException("Payment details not found");
    }

    /**
     * Get Payment Details based on PaymentId.
     */
    @SneakyThrows
    @GetMapping(path = "/payments/{paymentId}")
    public ResponseEntity<GetPaymentDetailsResponse> retrievePaymentDetails(@Valid @PathVariable String paymentId, @RequestHeader Map<String, String> headers) {
        log.info("payment Id : {}", paymentId);
        platformId = validateClientHeader(headers);

        GetPaymentDetailsResponse getPaymentDetailsResponse = bankService.retrievePaymentDetailsByID(paymentId, platformId);
        if (getPaymentDetailsResponse != null) {
            return new ResponseEntity<>(getPaymentDetailsResponse, new HttpHeaders(), HttpStatus.OK);
        }
        throw new PaymentDetailsNotFoundException("Payment details not found");
    }

    /**
     * Validate Idempotency-Key exists in header
     */
    private String validateIdempotencyHeader(Map<String, String> headers) throws Exception {
        String idempotencyKey = headers.keySet().stream().filter(x -> x.equalsIgnoreCase("idempotency-key")).findFirst().orElse(null);
        if (!StringUtils.hasText(idempotencyKey)) {
            throw new Exception(" 'Idempotency-Key' header is missing");
        }
        log.info("Idempotency-Key: {}", headers.get(idempotencyKey));
        return headers.get(idempotencyKey);
    }

    /**
     * Validating Client Header.
     */
    private String validateClientHeader(Map<String, String> headers) throws Exception {
        String clientName = headers.keySet().stream().filter(x -> x.equalsIgnoreCase("X-M11-PlatformId")).findFirst().orElse(null);
        if (!StringUtils.hasText(clientName)) {
            throw new Exception(" 'X-M11-PlatformId' header is missing");
        }
        return headers.get(clientName);
    }

    private boolean getXDebugEnabledHeaderVal(Map<String, String> headers) {
        String debugEnabledKey = headers.keySet().stream().filter(x -> x.equalsIgnoreCase("X-DebugEnabled")).findFirst().orElse(null);
        if (StringUtils.hasText(debugEnabledKey)) {
            log.info("X-DebugEnabled: {}", headers.get(debugEnabledKey));
            if (headers.get(debugEnabledKey).equalsIgnoreCase("true")) {
                return true;
            }
        }
        return false;
    }

}
