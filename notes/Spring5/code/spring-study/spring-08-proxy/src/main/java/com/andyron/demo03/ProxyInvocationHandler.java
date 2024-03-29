package com.andyron.demo03;

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
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    /**
     生成得到代理类
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    /**
     处理代理实例，并返回结果
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质是反射
        seeHouse();
        Object result = method.invoke(rent, args);
        fare();
        return result;
    }

    public void seeHouse() {
        System.out.println("中介带你看房子");
    }

    public void fare() {
        System.out.println("收中介费");
    }
}
