package com.andyron.spring6.iocxml.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author andyron
 **/
public class MyBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3 bean后置处理器（初始化之前）");
        System.out.println(beanName + "::" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5 bean后置处理器（初始化之后）");
        System.out.println(beanName + "::" + bean);
        return bean;
    }
}
