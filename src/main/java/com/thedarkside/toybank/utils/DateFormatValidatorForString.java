package com.thedarkside.toybank.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatValidatorForString implements ConstraintValidator<ISODateFormat, String> {

    private String format;

    public void initialize(ISODateFormat constraintAnnotation) {
        format = constraintAnnotation.message();
    }

    @Override public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {

        if ( date == null || date.isEmpty() ) {
            return true;
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        try {
            df.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }


}