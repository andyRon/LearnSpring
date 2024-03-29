package com.andyron.springcloud.service;

import com.andyron.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务降级
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    /**
     * 失败就创建DeptClientService
     */
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {  // 匿名内部类
            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("id=>" + id + "没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setDb_source("没有数据");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
