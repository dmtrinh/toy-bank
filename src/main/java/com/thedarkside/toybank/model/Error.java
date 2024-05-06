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
public class Error {
    String code;
    String docUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<String> messages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String idempotencyKey;
    String paymentId;

    public Error(String code, String docUrl, String message) {
        this.code = code;
        this.docUrl = docUrl;
        this.message = message;
    }

    public Error(String code, String docUrl, List<String> messages) {
        this.code = code;
        this.docUrl = docUrl;
        this.messages = messages;
    }
}