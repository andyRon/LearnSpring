package com.andyron.controller;

import com.andyron.dao.DepartmentDao;
import com.andyron.dao.EmployeeDao;
import com.andyron.pojo.Department;
import com.andyron.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author Andy Ron
 */
@Controller
public class EmployeeController {

//    @GetMapping("/elist")
//    public String list(Model model) {
//        Collection<Employee> employees = new EmployeeDao().getAll();
//
//        model.addAttribute("employees", employees);
//
//        return "list";
//    }

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAdd(Model model) {
        //查出部门的所有信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String add(Employee employee) {
        System.out.println(employee);
//        添加的操作
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //去员工的修改页面
    @GetMapping("/upemp/{id}")
    public String toupdataEmp(@PathVariable("id") Integer id, Model model) {
        //查出原来的数据
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);

        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updataEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") int id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
