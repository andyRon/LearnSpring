package com.andyron.springboot.controller;

import com.andyron.springboot.dao.EmployeeDao;
import com.andyron.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author Andy Ron
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    // 查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();

        // 放在请求域中
        model.addAttribute("emps", employees);

        return "emp/list";
    }
}
