package com.thedarkside.toybank.utils;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BankId implements ConstraintValidator<ValidateBank, Object> {
    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final ValidateBank constraintAnnotation) {
        firstFieldName = constraintAnnotation.routingNumber();
        secondFieldName = constraintAnnotation.bic();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, final ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(firstFieldName);
        Object fieldMatchValue = new BeanWrapperImpl(value)
                .getPropertyValue(secondFieldName);

        boolean firstFieldValueFound = fieldValue!=null && !fieldValue.toString().isEmpty();
        boolean secondFieldValueFound = fieldMatchValue!=null && !fieldMatchValue.toString().isEmpty();

        if (firstFieldValueFound && secondFieldValueFound) {
            return false;
        } else if (firstFieldValueFound || secondFieldValueFound){
            return true;
        }
        return false;
    }
}
