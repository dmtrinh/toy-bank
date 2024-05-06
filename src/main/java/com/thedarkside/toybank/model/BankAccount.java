package com.thedarkside.toybank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @NotNull
    @Valid
    Bank bank;
    @NotBlank
    String accountNumber;
}
