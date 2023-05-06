package com.andyron.spring6.validator1;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * @author andyron
 **/
public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(-10);
        person.setName("andy");

        // 创建person对应dtabinder
        DataBinder binder = new DataBinder(person);

        // 设置校验器
        binder.setValidator(new PersonValidator());

        // 调用方法执行校验
        binder.validate();

        // 输出校验结果
        BindingResult result = binder.getBindingResult();
        System.out.println(result.getAllErrors());
    }
}
