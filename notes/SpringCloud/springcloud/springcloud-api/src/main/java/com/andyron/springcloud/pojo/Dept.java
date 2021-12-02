package com.andyron.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Andy Ron
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)  // 开启链式写法
public class Dept implements Serializable {

    private Long deptno;
    private String dname;

    // 存储数据来自哪个数据库， 微服务，一个服务对应一个数据库，同一个信息可能存在不同数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
