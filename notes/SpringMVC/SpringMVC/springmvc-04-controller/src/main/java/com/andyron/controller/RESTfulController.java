package com.andyron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy Ron
 */
@Controller
public class RESTfulController {

    /*
    http://localhost:8080/s4/add?a=1&b=3
    http://localhost:8080/s4/add/a/b

     */


    @RequestMapping("/add/{a}/{b}")
    public String test(@PathVariable int a, @PathVariable int b, Model model) {

        model.addAttribute("msg", a + b);

        return "test";
    }

    @RequestMapping(value = "/add2/{a}/{b}", method = RequestMethod.POST)
//    @PostMapping("/add2/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {

        model.addAttribute("msg", "结果为" + (a + b));

        return "test";
    }
}
