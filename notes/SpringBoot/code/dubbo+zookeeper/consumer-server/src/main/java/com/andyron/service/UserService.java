package com.andyron.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service  // 放入到容器中，注意不是dubbo的
public class UserService {

    // 想拿到provider-server提供的票，要去服务中线拿服务
    @DubboReference // 远程引用，对应本地的@Autowired。1 POM坐标，2定义（和provider-server）路径相同的接口（TicketService）
    TicketService ticketService;

    public void buyTicket() {
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心拿到===>" + ticket);
    }
}
