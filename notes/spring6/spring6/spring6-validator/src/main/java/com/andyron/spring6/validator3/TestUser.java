package com.andyron.spring6.validator3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author andyron
 **/
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService myService = context.getBean(MyService.class);
        User user = new User();
        user.setName("andy");
        user.setAge(10);
        user.setPhone("13553575588");
        user.setMessage("test a custom");
        myService.testParams(user);


    }
}
