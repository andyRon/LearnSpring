package com.andyron.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andy Ron
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello...";
    }
}
