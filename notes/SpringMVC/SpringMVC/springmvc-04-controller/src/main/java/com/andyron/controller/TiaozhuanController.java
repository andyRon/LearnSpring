package com.andyron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过SpringMVC来实现转发和重定向 - 无需视图解析器
 * 测试前，需要在配置文件中把视图解析器配置去掉
 * @author Andy Ron
 */
@Controller
public class TiaozhuanController {
    @RequestMapping("/rsm/t1")
    public String test1(){
        //转发
        return "/index.jsp";
    }
    @RequestMapping("/rsm/t2")
    public String test2(){
        //转发二
        return "forward:/index.jsp";
    }
    @RequestMapping("/rsm/t3")
    public String test3(){
        //重定向
        return "redirect:/index.jsp";
    }
}
