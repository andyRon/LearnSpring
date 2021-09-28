package com.andyron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andy Ron
 */
@Controller
public class TiaozhuanController2 {
    @RequestMapping("/rsm2/t1")
    public String test1(){
        // 默认就可以转发
        return "test";
    }
    @RequestMapping("/rsm2/t2")
    public String test2(){
        //重定向
        return "redirect:/index.jsp";
    }
}
