package com.andyron.controller;

import com.andyron.dao.EmployeeDao;
import com.andyron.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author Andy Ron
 */
@Controller
public class EmployeeController {

    @GetMapping("/elist")
    public String list(Model model) {
        Collection<Employee> employees = new EmployeeDao().getAll();

        model.addAttribute("employees", employees);

        return "list";
    }
}
