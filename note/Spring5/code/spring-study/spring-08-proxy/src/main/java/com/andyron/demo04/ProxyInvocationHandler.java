package com.andyron.demo04;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 代理角色的处理程序，用它来自动生成代理类！
 做两件事：
    invoke，执行它要真正执行的方法
    得到代理类
 */
public class ProxyInvocationHandler implements InvocationHandler {

    /**
     被代理的接口
     */
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     生成得到代理类
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     处理代理实例，并返回结果
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    public void log(String msg) {
        System.out.println("执行了" + msg + "方法");
    }
}
