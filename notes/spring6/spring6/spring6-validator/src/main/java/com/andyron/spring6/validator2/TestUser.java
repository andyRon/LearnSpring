package com.andyron.spring6.validator2;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author andyron
 **/
public class TestUser {
    @Test
    public void testValidationOne() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation1 validation1 = context.getBean(MyValidation1.class);

        User user = new User();
        user.setName("andy");
        user.setAge(20);
        boolean message = validation1.validatoByUserOne(user);
        System.out.println(message);
    }

    @Test
    public void testValidationTwo() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation2 validation2 = context.getBean(MyValidation2.class);

        User user = new User();
        user.setName("andy");
        user.setAge(-1);
        boolean message = validation2.validatoByUserTwo(user);
        System.out.println(message);
    }
}
