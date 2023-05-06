package com.andyron.spring6.validator2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

/**
 * @author andyron
 **/
@Service
public class MyValidation2 {
    // spring的
    @Autowired
    private Validator validator;

    public boolean validatoByUserTwo(User user) {
        BindException bindException = new BindException(user, user.getName());
        validator.validate(user, bindException);

        System.out.println(bindException.getAllErrors());
        return bindException.hasErrors();
    }
}
