package com.andyron.sb01.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author andyron
 **/
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {TelephoneNumberValidator.class})  // 指定校验器
public @interface TelephoneNumber {
    String message() default "Invalid telephone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
