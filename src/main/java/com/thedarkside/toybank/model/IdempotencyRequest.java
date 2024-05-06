package com.thedarkside.toybank.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IdempotencyRequest {

    private String idempotencyKey;
    private String clientId;
    private String requestMethod;
    private String urlPath;
    private LocalDateTime requestDatetime;
    private String requestPayload;
    private String responsePayload;

    // in seconds
    private Long ttl;
}
