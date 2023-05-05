package com.andyron.spring6.resource.controller;

import com.andyron.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * @author andyron
 **/
@Controller("myUserController") // autowired包里也有UserController，为了防止冲突，取个名字
public class UserController {

    // 根据名称进行注入
//    @Resource(name = "myUserService")
//    private UserService userService;

    // 根据类型注入
    @Resource
    private UserService userService;

    public void add() {
        System.out.println("controller");
        userService.add();
    }
}
