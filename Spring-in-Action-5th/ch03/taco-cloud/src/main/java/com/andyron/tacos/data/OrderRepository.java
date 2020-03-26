package com.andyron.tacos.data;

import com.andyron.tacos.Order;

public interface OrderRepository {

    Order save(Order order);
}
