package com.andyron.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andy Ron
 */
@RestController
public class HelloController {

    @GetMapping("/t1")
    public String test() {
        System.out.println("HelloController---->t1");
        System.out.println(System.getProperty("file.encoding"));
        return "OK";
    }
}
