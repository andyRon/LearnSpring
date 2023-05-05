package com.andyron.spring6.autowired;

import com.andyron.spring6.autowired.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author andyron
 **/
public class TestUserController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController bean = context.getBean(UserController.class);
        bean.add();
    }
}
