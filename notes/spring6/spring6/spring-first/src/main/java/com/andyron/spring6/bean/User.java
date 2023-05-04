package com.andyron.spring6.bean;

/**
 * @author andyron
 **/
public class User {
    public User() {
        System.out.println("0: 无参数构造方法执行");
    }
    public void sayHello() {
        System.out.println("hello");
    }

    public void add() {
        System.out.println("add....");
    }
}
