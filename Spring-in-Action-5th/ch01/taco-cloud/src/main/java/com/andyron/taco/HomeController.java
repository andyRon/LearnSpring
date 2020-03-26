package com.andyron.taco;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Andy Ron
 */

@Controller
public class HomeController {

    @GetMapping("/")  // 处理对路径"/"的请求
    public String home() {
        return "home";  // 返回视图名
    }
}
