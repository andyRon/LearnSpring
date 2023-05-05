package com.andyron.spring6.autowired.controller;

import com.andyron.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author andyron
 **/
@Controller
public class UserController {
    // 第一种方式 属性注入
//    @Autowired
//    private UserService userService;

    // 第二种方式 set方式注入
//    private UserService userService;
//    @Autowired
//    public void setUserService1(UserService userService) {
//        this.userService = userService;
//    }

    // 第三种方式 构造方法注入
//    private UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // 第四种方式 形参上注入
//    private UserService userService;
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

    // 第五种方式 只有一个有参构造函数式，不需要@Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        System.out.println("controller");
        userService.add();
    }
}
