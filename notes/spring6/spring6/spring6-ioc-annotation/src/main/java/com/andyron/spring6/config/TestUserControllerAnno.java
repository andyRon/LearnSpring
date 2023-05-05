package com.andyron.spring6.config;

import com.andyron.spring6.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author andyron
 **/
public class TestUserControllerAnno {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController bean = context.getBean(UserController.class);
        bean.add();
        System.out.println("xxxx");
    }
}
