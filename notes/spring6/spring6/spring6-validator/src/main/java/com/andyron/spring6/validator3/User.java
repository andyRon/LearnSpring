package com.andyron.spring6.validator3;

import com.andyron.spring6.validator4.ConnotBlank;
import jakarta.validation.constraints.*;

/**
 * @author andyron
 **/
public class User {
    @NotNull
    private String name;
    @Max(120)
    @Min(0)
    private int age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    @ConnotBlank // 自定义
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
