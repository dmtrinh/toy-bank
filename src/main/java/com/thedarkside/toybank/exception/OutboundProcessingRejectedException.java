package com.thedarkside.toybank.exception;

public class OutboundProcessingRejectedException extends Exception {
    public OutboundProcessingRejectedException(String errorMsg) {
        super(errorMsg);
    }
}