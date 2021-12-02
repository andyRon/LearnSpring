package com.andyron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andy Ron
 */
@Controller
//@RestController   // 不会调用视图，直接返回数据，用于json数据返回
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        // 封装数据
        model.addAttribute("msg", "Hello, Spring MVC Annotation!");

        return "hello"; // 会被视图解析器处理




    }

}
