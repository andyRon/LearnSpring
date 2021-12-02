package com.andyron.pojo;

/**
 * @author Andy Ron
 */
public class User {

    private String name;

    public User() {
        System.out.println("User的无参数构造方法");
    }

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void show() {
        System.out.println("name=" + name);
    }
}
