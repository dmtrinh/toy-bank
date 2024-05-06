package com.thedarkside.toybank.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EntityType {
    INDIVIDUAL("INDIVIDUAL"),
    ORGANIZATION("ORGANIZATION");

    private String value;

    EntityType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
