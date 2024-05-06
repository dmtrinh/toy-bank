package com.thedarkside.toybank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import com.thedarkside.toybank.utils.ISODateFormat;

import java.io.Serial;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutboundPaymentRequest {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @Valid
    Party originator;

    @NotNull
    @Valid
    BankAccount originatingAccount;

    @NotNull
    @Valid
    Party counterparty;

    @NotNull
    @Valid
    BankAccount counterpartyAccount;
    String memo;

    @NotNull
    @DecimalMin("0.01") @DecimalMax("99999999.99")
    double amount;

    @ISODateFormat
    String paymentDate;
}
