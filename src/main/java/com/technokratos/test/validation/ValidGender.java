package com.technokratos.test.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = com.technokratos.test.validation.GenderValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidGender {
    String message() default "Invalid gender. Enter 'MALE' or 'FEMALE'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}