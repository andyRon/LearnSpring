package com.andyron.controller;

import com.andyron.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Andy Ron
 */
@Controller
@RequestMapping("/user")
public class UserController {

    // http://localhost:8080/user/t1?username=xxx
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {
        // 1 接受前端参数
        System.out.println("前端参数为：" + name);
        // 2 将返回结果返回给前端，使用Model
        model.addAttribute("msg", name);
        // 3 视图跳转
        return "test";
    }

    /**
        前端接受一个对象：id，name，age
        1 接受前端用户传递的参数，判断参数名字，假设参数名和方法上参数名相同，可直接使用
        2 假设传递的是一个对象，匹配对象中的字段名是否与方法的参数对象属性是否相同，相同的就使用

     */
    @GetMapping("t2")
    public String test2(User user) {
        System.out.println(user);
        return "test";

    }
}
