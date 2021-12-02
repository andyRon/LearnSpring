package com.andyron.springcloud.controller;

import com.andyron.springcloud.pojo.Dept;
import com.andyron.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供Restful服务
 * @author Andy Ron
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 获取一些配置的信息，得到具体的微服务
     */
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    @GetMapping("/dept/discovery")
    public Object discover() {
        // 获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println("微服务清单：" + services);

        // 通过微服务id，得到一个具体的微服务信息
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId() + "\t" +
                    instance.getScheme() + "\t" +
                    instance.getMetadata() + "\t"
            );
        }
        return this.client;
    }
}
