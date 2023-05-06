package com.andyron.aop.annoaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author andyron
 **/
public class TestAop {
    @Test
    void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("annoaop.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(2, 5);
    }
}
