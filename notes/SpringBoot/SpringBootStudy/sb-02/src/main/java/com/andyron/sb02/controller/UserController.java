package com.andyron.sb02.controller;

import com.andyron.sb02.annotation.ApiVersion;
import com.andyron.sb02.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andyron
 **/
@RestController
@RequestMapping("/api/{v}/user")
public class UserController {

    @GetMapping("get")
    public User getUser() {
        return User.builder().age(19).name("andy, default").build();
    }

    @ApiVersion("1.0.0")
    @GetMapping("get")
    public User getUserV1() {
        return User.builder().age(19).name("andy, v1.0.0").build();
    }


    @ApiVersion("1.1.0")
    @GetMapping("get")
    public User getUserV11() {
        return User.builder().age(19).name("andy, v1.1.0").build();
    }

    @ApiVersion("1.1.2")
    @GetMapping("get")
    public User getUserV112() {
        return User.builder().age(19).name("andy, v1.1.2").build();
    }
}
