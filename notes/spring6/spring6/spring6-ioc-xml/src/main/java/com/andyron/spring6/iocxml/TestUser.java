package com.andyron.spring6.iocxml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author andyron
 **/
public class TestUser {
    @Test
    public void user() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //
        User user = (User) context.getBean("user");
        System.out.println(user);
        //
        User user1 = context.getBean(User.class);
        System.out.println(user1);

        User user2 = context.getBean("user", User.class);
        System.out.println(user2);
    }
}
