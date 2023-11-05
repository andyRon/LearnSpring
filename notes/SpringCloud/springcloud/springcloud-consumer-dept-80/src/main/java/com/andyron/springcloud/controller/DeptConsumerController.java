package com.andyron.springcloud.controller;

import com.andyron.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Andy Ron
 */
@RestController
public class DeptConsumerController {

    // 理解：消费者，没有service层,直接通过rest方式获取数据
    // (url, 实体：map, Class<T> responseType)

    /**
     * 提供多种便捷访问远程http服务的方法，简单的Restful的模板
     */
    @Autowired
    private RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    // Ribbon。访问地址应该是变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    /**
     * 消费方根据id查询部门信息
     */
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        // getForObject的参数：服务提供方地址(接口),返回类型.class
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }
    /**
     * 消费方添加部门信息
     */
    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept) {
        // postForObject的参数：服务提供方地址(接口),参数实体,返回类型.class
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }
    /**
     * 消费方查询部门信息列表
     */
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }


}
