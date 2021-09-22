package com.andyron.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 @Component注解就等价于<bean id="user" class="com.andyron.pojo.User ></bean>
 */
@Component
@Scope("prototype")
public class User {

    /**
     相当于 <property name="name" value="Andy"></property>
     */
    @Value("Andy")
    public String name;
}
