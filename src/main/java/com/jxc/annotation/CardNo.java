package com.jxc.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CardNoValidator.class)
public @interface CardNo {
    String message() default "{edu.cqie.ssm.cardNoErrorMessage}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
