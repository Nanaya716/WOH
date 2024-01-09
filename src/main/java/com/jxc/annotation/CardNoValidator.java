package com.jxc.annotation;

import com.jxc.util.IdCardValidatorUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CardNoValidator implements ConstraintValidator<CardNo, Object> {
    @Override
    public void initialize(CardNo constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null) {
            return true;//身份证号未传递时，不做校验
        }
        return IdCardValidatorUtils.isValidate18Idcard(o.toString());
    }
}
