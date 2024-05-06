package com.thedarkside.toybank.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    CREATED("CREATED"),
    WAREHOUSED("WAREHOUSED"),
    PROCESSING("PROCESSING"),
    PENDING_CALLBACK("PENDING_CALLBACK"),
    COMPLIANCE_HOLD("COMPLIANCE_HOLD"),
    QUEUED_FOR_TRANSMISSION("QUEUED_FOR_TRANSMISSION"),
    TRANSMITTED("TRANSMITTED"),
    COMPLETED("COMPLETED"),
    REJECTED("REJECTED"),
    REVERSED("REVERSED"),
    RETURNED("RETURNED"),
    CANCELLED("CANCELLED");

    private String value;

    Status(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
