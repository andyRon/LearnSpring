package com.andyron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andy Ron
 */
@Controller
public class IndexCotroller {

    @RequestMapping("/404")
    public String index() {

        return "404";
    }
}
