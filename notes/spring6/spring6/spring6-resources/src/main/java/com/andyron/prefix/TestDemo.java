package com.andyron.prefix;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author andyron
 **/
public class TestDemo {


    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        Resource resource = context.getResource("andy.txt");
        System.out.println(resource.getDescription());
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:bean.xml");
        System.out.println(context);
        Resource resource = context.getResource("andy.txt");
        System.out.println(resource.getDescription());
    }

    @Test
    public void test3() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean*.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
