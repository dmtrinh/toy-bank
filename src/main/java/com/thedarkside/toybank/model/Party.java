package com.thedarkside.toybank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serial;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Party {

    @Serial
    private static final long serialVersionUID = 1L;
    @NotBlank
    @Size(max = 64, message = "Maximum length of 64")
    @Pattern(regexp = "^[a-zA-Z0-9-,#./'&! \\p{L}+]*$")
    String name1;
    @Size(max = 64, message = "Maximum length of 64")
    @Pattern(regexp = "^[a-zA-Z0-9-,#./'&! \\p{L}+]*$")
    String name2;
    @NotBlank
    @Size(max = 64, message = "Maximum length of 64")
    @Pattern(regexp = "^[a-zA-Z0-9-,#./: \\p{L}+]*$")
    String line1;
    @Size(max = 64, message = "Maximum length of 64")
    @Pattern(regexp = "^[a-zA-Z0-9-,#./: ]*$")
    String line2;
    @Size(max = 64, message = "Maximum length of 64")
    @Pattern(regexp = "^[a-zA-Z0-9-,#./: ]*$")
    String line3;
    @NotBlank
    @Size(max = 64, message = "Maximum length of 64")
    @Pattern(regexp = "^[a-zA-Z0-9-,#. ]*$")
    String city;
    @NotBlank
    @Size(max = 64, message = "Maximum length of 64")
    @Pattern(regexp = "^[a-zA-Z0-9-,#. ]*$")
    String state;
    @NotBlank
    @Size(max = 10, message = "Maximum length of 10")
    @Pattern(regexp = "^[a-zA-Z0-9-,#. ]*$")
    String postalCode;
    @NotNull
    Iso3166CountryCode country;

    @NotNull
    EntityType entityType;
    String taxId;

    String email;
    String phone;
}
