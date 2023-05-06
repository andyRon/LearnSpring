package com.andyron.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author andyron
 **/
public class TestResourceBean {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        ResourceBean resourceBean = context.getBean("resourceBean", ResourceBean.class);
        resourceBean.parse();
    }
}
