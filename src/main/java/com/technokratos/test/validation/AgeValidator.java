package com.technokratos.test.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<ValidAge, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value >= 14 && value <= 100;
    }

}
