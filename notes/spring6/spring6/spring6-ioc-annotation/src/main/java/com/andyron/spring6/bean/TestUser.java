package com.andyron.spring6.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author andyron
 **/
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
