package com.andyron.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 方式三：使用注解实现AOP！
 * @author Andy Ron
 */
@Aspect // 标注这个类是一个切面
public class AnnotationPointcut {

    @Before("execution(* com.andyron.service.UserServiceImpl.*(..))") // 标注切入点
    public void before() {
        System.out.println("=======方法执行之前（注解方式）========");
    }

    @After("execution(* com.andyron.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("=======方法执行之后（注解方式）========");
    }

    // 在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.andyron.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
//        System.out.println(jp.getSignature());
        Object process = jp.proceed(); // 执行方法
        System.out.println("环绕后");
    }
}
