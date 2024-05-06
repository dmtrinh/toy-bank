package com.thedarkside.toybank.exception;

public class PaymentRegistrationFailedException extends Exception {
    public PaymentRegistrationFailedException(String expMessage) {
        super(expMessage);
    }
}
