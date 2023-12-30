package com.andyron.pojo;

/**
 * @author Andy Ron
 */
public class User {

    private String name;

    public User() {
        System.out.println("User被无参数构造创建");
    }

    public User(String name) {
        System.out.println("User被有参数构造创建");
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void show() {
        System.out.println("User:(name=" + name + ")");
    }
}
