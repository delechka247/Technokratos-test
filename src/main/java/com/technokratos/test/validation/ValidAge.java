package com.technokratos.test.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = com.technokratos.test.validation.AgeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAge {
    String message() default "Invalid age. Enter value between 14 and 100";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
