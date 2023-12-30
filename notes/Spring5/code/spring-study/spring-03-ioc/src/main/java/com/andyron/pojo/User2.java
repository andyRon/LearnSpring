package com.andyron.pojo;

/**
 * @author Andy Ron
 */
public class User2 {

    private String name;

    public User2() {
        System.out.println("User2被无参数构造创建");
    }


    public void setName(String name) {
        System.out.println("User2被有参数构造创建");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void show() {
        System.out.println("User2(name=" + name + ")");
    }
}
