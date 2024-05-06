package com.thedarkside.toybank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllPaymentsResponse {
    String paymentId;
    PaymentRail paymentRail;
    PaymentDirection paymentDirection;
    String createdDateTime;
    double amount;
}
