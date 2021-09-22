package com.andyron.pojo;

/**
 * @author Andy Ron
 */
public class User2 {

    private String name;

    public User2() {
        System.out.println("User2被创建");
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
