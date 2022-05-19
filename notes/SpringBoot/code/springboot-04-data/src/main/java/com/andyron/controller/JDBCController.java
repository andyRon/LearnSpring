package com.andyron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Andy Ron
 */
@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 没有实体查询数据库数据
     */
    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select * from mybatis.user";
        List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);

        return userList;
    }

    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into mybatis.user (id, name, pwd) values(4, 'xxx', 'xxxx')";
        jdbcTemplate.update(sql);
        return "add-ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id) {
        String sql = "update mybatis.user set name=?, pwd=? where id = " + id;
        Object[] objects = new Object[2];
        objects[0] = "小小";
        objects[1] = "adaf";
        jdbcTemplate.update(sql, objects);
        return "update-ok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        String sql = "delete from mybatis.user where id = " + id;
        jdbcTemplate.update(sql);
        return "delete-ok";
    }


}
