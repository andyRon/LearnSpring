package com.andyron.spring6.iocxml.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author andyron
 **/
public class TestBook {
    @Test
    void testSetter() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    void testCon() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book bookCon = context.getBean("bookCon", Book.class);
        System.out.println(bookCon);
    }
}
