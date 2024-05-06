package com.thedarkside.toybank.exception;

public class UnauthorizedClientException extends Exception {
    
    public UnauthorizedClientException(String errorMsg) {
        super(errorMsg);
    }
}
