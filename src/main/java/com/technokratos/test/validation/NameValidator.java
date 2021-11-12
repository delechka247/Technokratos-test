package com.technokratos.test.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.matches("^[А-Я][а-я]{2,19}$") || value.matches("^[A-Z][a-z]{2,19}$");
    }
}