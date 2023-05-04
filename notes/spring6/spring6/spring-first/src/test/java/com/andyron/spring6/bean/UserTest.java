package com.andyron.spring6.bean;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author andyron
 **/
public class UserTest {
    // TODO slf4j
    private Logger logger = LoggerFactory.getLogger(UserTest.class);
    @Test
    public void testHelloWorld() {
        ApplicationContext context = new ClassPathXmlApplicationContext("springs.xml");
        User user = (User) context.getBean("user");
//        User user = context.getBean(User.class);
//        User user = context.getBean("user", User.class);
        user.add();
        logger.info("执行成功");
    }

    // 反射创建对象
    @Test
    public void testUserObject1() throws Exception {
        Class<?> clazz = Class.forName("com.andyron.spring6.bean.User");
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);

    }
}
