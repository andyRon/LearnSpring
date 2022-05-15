package com.andyron.tacocloud.data;

import com.andyron.tacocloud.pojo.Order;

public interface OrderRepository {

    Order save(Order order);
}
