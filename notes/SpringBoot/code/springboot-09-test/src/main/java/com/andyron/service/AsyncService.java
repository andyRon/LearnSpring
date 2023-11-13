package com.andyron.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Andy Ron
 */
@Service
public class AsyncService {
    // 告诉spring，这是一个异步方法
    @Async
    public void hello() {
        // 假装正在处理数据，使用线程设置一些延时，模拟同步等待的情况
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理");
    }
}
