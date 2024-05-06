package com.thedarkside.toybank.exception;

public class OutboundExceptionWithReq extends Exception{
    private String request;
    public OutboundExceptionWithReq(String expMessage) {
        super(expMessage);

    }

    public OutboundExceptionWithReq(String expMessage, String request) {
        super(expMessage);
        this.request = request;
    }

    public String getRequest() {
        return this.request;
    }
}
