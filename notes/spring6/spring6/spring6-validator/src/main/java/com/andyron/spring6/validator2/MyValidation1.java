package com.andyron.spring6.validator2;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author andyron
 **/
@Service
public class MyValidation1 {
    // 原生的
    @Autowired
    private Validator validator;

    public boolean validatoByUserOne(User user) {
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        return validate.isEmpty();
    }
}
