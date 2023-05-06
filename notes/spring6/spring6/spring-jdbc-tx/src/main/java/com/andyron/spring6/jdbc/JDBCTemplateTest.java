package com.andyron.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @author andyron
 **/
@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加、修改、删除操作都是update
    @Test
    public void testUpdate() {
//       String sql = "Insert Into t_emp Values(null, ?, ?, ?)";
//        int rows = jdbcTemplate.update(sql, "东方不败", 35, "未知");
//        System.out.println(rows);

//        String sql = "Update t_emp set name=? where id=?";
//        int res = jdbcTemplate.update(sql, "东方不败plus", 4);
//        System.out.println(res);

        String sql = "Delete from t_emp where id=?";
        int res = jdbcTemplate.update(sql, 4);
        System.out.println(res);
    }

    // 查询
    @Test
    public void testSelect() {
        // 写法一
        String sql = "Select * from t_emp where id=?";
//        Emp empResult = jdbcTemplate.queryForObject(sql,  (rs, rowNum) -> {
//            Emp emp = new Emp();
//            emp.setId(rs.getInt("id"));
//            emp.setName(rs.getString("name"));
//            emp.setAge(rs.getInt("age"));
//            emp.setSex(rs.getString("sex"));
//            return emp;
//        }, 1);
//        System.out.println(empResult);

        // 写法二
        Emp empResult2 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 2);
        System.out.println(empResult2);
    }
    //查询多条数据为一个list集合
    @Test
    public void testSelectList(){
        String sql = "select * from t_emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(list);
    }

    //查询：返回单个值
    @Test
    public void selectCount(){
        String sql = "select count(id) from t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}
