package com.thedarkside.toybank.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD,TYPE, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = BankId.class)
@Documented
public @interface ValidateBank {
    String message() default "Provide routingNumber or bic";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String routingNumber();
    String bic();
}
