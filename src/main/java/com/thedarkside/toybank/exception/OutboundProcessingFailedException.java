package com.thedarkside.toybank.exception;

public class OutboundProcessingFailedException extends Exception {
    public OutboundProcessingFailedException(String errorMsg) {
        super(errorMsg);
    }
}
