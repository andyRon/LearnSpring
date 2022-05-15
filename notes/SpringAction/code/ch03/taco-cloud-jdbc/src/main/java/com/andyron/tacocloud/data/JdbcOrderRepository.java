package com.andyron.tacocloud.data;

import com.andyron.tacocloud.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Order save(Order order) {
        return null;
    }
}

