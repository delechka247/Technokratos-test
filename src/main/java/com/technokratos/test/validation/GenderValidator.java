package com.technokratos.test.validation;

import com.technokratos.test.utils.Gender;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<ValidGender, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.equals(Gender.MALE.toString()) || value.equals(Gender.FEMALE.toString());
    }
}
