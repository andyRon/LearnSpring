package com.andyron.spring6.springi18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * @author andyron
 **/
public class TestSprintI18n {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 传递动态参数，使用数组形式对应{0} {1}顺序
        Object[] objs = new Object[]{"world", new Date().toString()};

        String message = context.getMessage("andyron.com", objs, Locale.CHINA);
        System.out.println(message);
    }
}
