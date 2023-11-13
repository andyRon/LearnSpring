package com.andyron.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Vector;

/**
 * @author Andy Ron
 */
@Service
public class ScheduledService {

    // 在特定时间执行这个方法  Timer
    // cron 表达式
    // 秒 分 时 日 月 周几
    /*
    40 30 23 * * ?          每天23点30分40秒执行一次
    30 0/5 18,10 * * ?      每天18和10点，每个5分钟执行一次
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void hello() {
        System.out.println("hello，你被执行了。。。");
    }
}
