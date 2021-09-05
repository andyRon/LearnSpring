package com.andyron.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Andy Ron
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            // 登录成功
            // 登录成功后定义一个session用于检查
            session.setAttribute("loginUser", username);
            // 防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        } else {
            // 登录失败
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }

}
