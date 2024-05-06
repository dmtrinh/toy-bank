package com.thedarkside.toybank.utils;

import org.slf4j.MDC;

import com.thedarkside.toybank.exception.BusinessRuleValidationFailedException;
import com.thedarkside.toybank.model.*;
import com.thedarkside.toybank.model.Error;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ValidationUtil {

    static final String PAST_DATES_ARE_NOT_ALLOWED = "# past dates are not allowed.";

    static final String DOC_URL = "https://thedarkside.io/docs/error-codes";

    public void validatePaymentRequest(OutboundPaymentRequest outboundPaymentRequest) throws BusinessRuleValidationFailedException {

        StringBuilder stringBuilder = new StringBuilder();
        if (isPaymentDateInThePast(outboundPaymentRequest.getPaymentDate())) {
            stringBuilder.append(PAST_DATES_ARE_NOT_ALLOWED);
        }

        String validationErrorMsg = stringBuilder.toString();
        if (!validationErrorMsg.isEmpty()) {
            throw new BusinessRuleValidationFailedException(stringBuilder.toString());
        }
    }

    private void addErrorToMap(Map<Integer, List<Error>> errorMap, String errorMsg, int i) {
        if (errorMap.get(i) != null) {
            errorMap.get(i).add(createError(errorMsg));
        } else {
            errorMap.put(i, createErrorList(errorMsg));
        }
    }

    private List<Error> createErrorList(String errorMsg) {
        List<Error> errorList = new ArrayList<>();
        errorList.add(createError(errorMsg));
        return errorList;
    }

    private Error createError(String errorMsg) {
        Error error = new Error("400", DOC_URL, errorMsg);
        error.setIdempotencyKey(MDC.get("IDEMPOTENCY_KEY"));
        error.setPaymentId(MDC.get("PAYMENT_ID"));
        return error;
    }

    private boolean isPaymentDateInThePast(String date) {
        boolean isPastDate = false;

        if (date != null && !date.isEmpty()) {
            LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate inputDate = LocalDate.parse(date, dtf);
            isPastDate = inputDate.isBefore(localDate);
        }
        return isPastDate;
    }
}
