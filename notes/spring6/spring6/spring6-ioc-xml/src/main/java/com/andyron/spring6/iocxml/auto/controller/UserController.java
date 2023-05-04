package com.andyron.spring6.iocxml.auto.controller;

import com.andyron.spring6.iocxml.auto.service.UserService;

/**
 * @author andyron
 **/
public class UserController {
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        System.out.println("UserController方法执行了。。。");
        // 调用service的方法
        userService.addUserService();
    }
}
