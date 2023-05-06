package com.andyron.aop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类
 * @author andyron
 **/
@Aspect
@Component
public class LogAspect {
    // 设置切入点和通知类型
    // 五种通知类型
    /*
    切入点表达式：`execution(访问修饰符 增强方法返回类型 增强方法所在类全类名.方法名 (参数列表)`
     */

    // 前置 @Before(value="切入点表达式配置切入点")
    @Before(value = "execution(public int com.andyron.aop.annoaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger --> 前置通知，方法名称：" + methodName + "，参数：" + Arrays.toString(args));
    }

    // 后置 @After
//    @After(value = "com.andyron.aop.annoaop.LogAspect.pointcut()") // 不在同一个类里
    @After(value = "pointcut()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 后置通知，方法名称：" + methodName);
    }

    /**
     * 返回 @AfterReturning
     * @param res  增强目标方法的返回值 参数名要与注解中returning的值相同
     */
    @AfterReturning(value = "execution(* com.andyron.aop.annoaop.CalculatorImpl.*(..))", returning = "res")
    public void afterReturningMethod(JoinPoint joinPoint, Object res) { //
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 返回通知，方法名称：" + methodName + "，返回结果：" + res);
    }

    // 异常 @AfterThrowing
    @AfterThrowing(value = "execution(* com.andyron.aop.annoaop.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 异常通知，方法名称：" + methodName + "异常：" + ex);
    }

    // 环绕 @Around
    @Around(value = "execution(* com.andyron.aop.annoaop.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String argString = Arrays.toString(joinPoint.getArgs());
        Object res = null;
        try {
            System.out.println("环绕通知===目标方法之前执行");

            // 调用目标方法
            res = joinPoint.proceed();
            System.out.println("环绕通知===目标方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知===目标方法出现异常执行");
        } finally {
            System.out.println("环绕通知===目标方法执行完毕执行");
        }
        return res;
    }

    // 重用切入点表达式（就是重复使用切入点表达式）
    @Pointcut(value = "execution(* com.andyron.aop.annoaop.CalculatorImpl.*(..))")
    public void pointcut() {}
}
