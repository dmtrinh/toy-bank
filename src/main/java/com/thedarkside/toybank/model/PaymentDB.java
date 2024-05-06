package com.thedarkside.toybank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class PaymentDB {
    String id;
    String platformId;
    Status status;
    Object requestPayload;
    PaymentRail paymentRail;
    PaymentDirection paymentDirection;
    String createdDateTime;
    double amount;
}
