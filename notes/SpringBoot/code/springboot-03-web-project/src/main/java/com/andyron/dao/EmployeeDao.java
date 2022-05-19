package com.andyron.dao;

import com.andyron.pojo.Department;
import com.andyron.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy Ron
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;
    // 员工有所属部分
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(10001, new Employee(10001, "andy", "1237642@qqcom", 1, new Department(101, "教学部")));
        employees.put(10002, new Employee(10002, "tom", "2237642@qqcom", 0, new Department(103, "市场部")));
        employees.put(10003, new Employee(10003, "json", "3237642@qqcom", 1, new Department(102, "教研部")));
        employees.put(10004, new Employee(10004, "love", "4237642@qqcom", 0, new Department(101, "教学部")));
        employees.put(10005, new Employee(10005, "jack", "5237642@qqcom", 1, new Department(104, "技术部")));
    }

    // 主键自增
    private static Integer initInt = 10006;

    // 增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initInt++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);

    }

    // 查询所有员工
    public Collection<Employee> getAll() {
        return employees.values();
    }

    // 通过id查询
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    // 删除
    public void delete(Integer id) {
        employees.remove(id);
    }
}
