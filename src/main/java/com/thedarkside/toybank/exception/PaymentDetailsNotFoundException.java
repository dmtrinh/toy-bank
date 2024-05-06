package com.thedarkside.toybank.exception;

public class PaymentDetailsNotFoundException extends Exception{
    public PaymentDetailsNotFoundException(String expMessage) {
        super(expMessage);
    }
}
