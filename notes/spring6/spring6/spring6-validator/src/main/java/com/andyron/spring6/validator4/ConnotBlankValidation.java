package com.andyron.spring6.validator4;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 校验类
 * @author andyron
 **/
public class ConnotBlankValidation implements ConstraintValidator<ConnotBlank, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && value.contains(" ")) {
            // 获取默认提示信息
            String template = context.getDefaultConstraintMessageTemplate();
            System.out.println("default message: " + template);
            // 禁用默认提示信息
            context.disableDefaultConstraintViolation();
            // 设置提示语
            context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(ConnotBlank constraintAnnotation) {
    }
}
