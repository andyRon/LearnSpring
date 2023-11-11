package com.andyron.controller;

import com.andyron.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Andy Ron
 */
//@Controller
@RestController  // 在类上直接使用 `@RestController` ，这样子，里面所有的方法都只会返回 json 字符串了，不用再每一个都添加`@ResponseBody` 。
public class UserController {

//    @ResponseBody // 表示不走视图解析器，直接返回给客户端
    @GetMapping("/j1")
//    @RequestMapping(value = "/j1", produces = "application/json;charset=utf-8") // 在配置文件统一配置json乱码问题
    public String test1() {
        User user = new User(1, "小明", 18);
        return user.toString();
    }

    @GetMapping("/j2")
//    @ResponseBody
    public String test2() throws JsonProcessingException {
        User user = new User(1, "小王", 18);

        ObjectMapper objectMapper = new ObjectMapper();  // 使用jackson
        String str = objectMapper.writeValueAsString(user); // json字符串
        return str; // 由于@ResponseBody或@RestController 注解，这里会将str转成json格式返回；
    }

    @GetMapping("/j3")
    public String test3() throws JsonProcessingException {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(1, "小王1号", 18));
        userList.add(new User(1, "小王2号", 18));
        userList.add(new User(1, "小王3号", 18));
        userList.add(new User(1, "小王4号", 18));

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userList);
    }

    @GetMapping("/j4")
    public String test4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //创建时间一个对象，java.util.Date
        Date date = new Date();
        return mapper.writeValueAsString(date); // Jackson 默认是会把时间转成timestamps形式
    }

    // 取消timestamps形式 ， 自定义时间格式
    @GetMapping("/j5")
    public String test5() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        return mapper.writeValueAsString(new Date());
        // "2023-11-11 10:28:38"
    }
}
