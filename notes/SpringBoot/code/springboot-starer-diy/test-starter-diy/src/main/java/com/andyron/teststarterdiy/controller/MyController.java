package com.andyron.teststarterdiy.controller;

import com.andyron.andyronspringbootstarterautoconfigure.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andyron
 **/
@RestController
public class MyController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello("hello");
    }
}
