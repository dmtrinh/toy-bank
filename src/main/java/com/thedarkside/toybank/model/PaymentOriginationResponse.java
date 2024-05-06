package com.thedarkside.toybank.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentOriginationResponse {
    String paymentId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String idempotencyKey;
    PaymentStatus paymentStatus;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<Error> error;

    public PaymentOriginationResponse(String paymentId, String idempotencyKey, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.idempotencyKey = idempotencyKey;
        this.paymentStatus = paymentStatus;
    }

    public PaymentOriginationResponse(List<Error> error) {
        this.error = error;
    }

    public PaymentOriginationResponse(String paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentOriginationResponse(String paymentId, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.paymentStatus = paymentStatus;
    }
}
