package com.andyron.spring6.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author andyron
 **/
@Component(value = "user") // 类似 <bean id="user" class="...">，value默认值就是类名（首字母小写）可省略
//@Repository
//@Service
//@Controller
public class User {
}
