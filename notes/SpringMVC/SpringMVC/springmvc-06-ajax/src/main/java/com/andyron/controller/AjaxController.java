package com.andyron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Andy Ron
 */
@Controller
public class AjaxController {

    @GetMapping("/t1")
    public String test() {
        return "test";
    }
}
