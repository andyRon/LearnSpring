package com.andyron.swagger.controller;

import com.andyron.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andy Ron
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Swagger!";
    }

    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }

    // 只要接口中，返回值中存在实体类，就会被扫描到swagger中
    @PostMapping("/user")
    public User user() {
        return new User();
    }

    @ApiOperation("Hello2接口方法注释")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username) {
        return "Hello, Swagger!" + username;
    }

    @PostMapping("/test2")
    public User test2(User user) {
        return user;
    }
}
