package com.thedarkside.toybank.exception;

public class BusinessRuleValidationFailedException extends Exception {
    public BusinessRuleValidationFailedException(String errorMsg) {
        super(errorMsg);
    }
}
