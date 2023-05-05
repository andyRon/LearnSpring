package com.andyron;

import com.andyron.bean.AnnotationApplicationContext;
import com.andyron.bean.ApplicationContext;
import com.andyron.service.UserService;

/**
 * @author andyron
 **/
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.andyron");
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
