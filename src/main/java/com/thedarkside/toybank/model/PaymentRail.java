package com.thedarkside.toybank.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentRail {
    ACH("ACH"),
    FEDNOW("FEDNOW"),
    FEDWIRE("FEDWIRE"),
    RTP("RTP"),
    SWIFT("SWIFT"),
    CRYPTO("CRYPTO"),
    SECRET("SECRET");

    private String value;

    PaymentRail(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
