package com.thedarkside.toybank.exception;

public class OutboundPaymentException extends Exception{
    public OutboundPaymentException(String expMessage) {
        super(expMessage);
    }

}
