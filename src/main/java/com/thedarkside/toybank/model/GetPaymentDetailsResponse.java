package com.thedarkside.toybank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPaymentDetailsResponse {
    String id;
    PaymentRail paymentRail;
    Party originator;
    BankAccount originatingAccount;
    Party counterparty;
    BankAccount counterpartyAccount;
    double amount;
    String memo;
    List<Metadata> additionalProperties;
    PaymentStatus paymentStatus;
    String paymentDate;
    PaymentDirection paymentDirection;
}
