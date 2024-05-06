package com.thedarkside.toybank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import com.thedarkside.toybank.utils.ValidateBank;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ValidateBank(routingNumber = "routingNumber", bic = "bic", message = "Provide routingNumber or bic")
public class Bank implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Size(min = 9, max = 9, message = "Length should be 9")
    String routingNumber;
    @Size(max = 11, message = "Maximum length is 11")
    String bic;
    @Size(max = 64, message = "Maximum length is 64")
    String name;
    @Valid
    Address address;
}
