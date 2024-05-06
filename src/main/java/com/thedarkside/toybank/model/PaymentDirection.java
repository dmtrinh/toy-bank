package com.thedarkside.toybank.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentDirection {
    INBOUND("INBOUND"),
    OUTBOUND("OUTBOUND");

    private String value;

    PaymentDirection(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
