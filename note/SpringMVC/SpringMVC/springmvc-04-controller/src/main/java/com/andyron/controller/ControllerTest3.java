package com.andyron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andy Ron
 */
@Controller
@RequestMapping("/c3")
public class ControllerTest3 {

    @RequestMapping("/t3")
    public String test(Model model) {
        model.addAttribute("msg", "ControllerTest3-test---");
        return "test";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("msg", "ControllerTest3-admin---");
        return "admin/home";
    }
}
