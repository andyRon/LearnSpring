package com.andyron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

/**
 * @author Andy Ron
 */
@Controller
public class IndexController {

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg", "hello, I come");

        model.addAttribute("users", Arrays.asList("dog", "cat"));

        return "test";
    }
}
