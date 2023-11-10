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
@RequestMapping("/HelloController")
public class HelloController {

    // 真实访问地址 : 项目名/HelloController/hello
    @RequestMapping("/hello")
    public String hello(Model model) {
        // 封装数据
        model.addAttribute("msg", "Hello, Spring MVC Annotation!");

        return "hello"; // 会被视图解析器处理，加上配置文件中的前后缀变成WEB-INF/jsp/**hello**.jsp
    }
}
