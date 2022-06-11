package com.andyron.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Component
@ConfigurationProperties(prefix = "teacher")
@Validated
public class Teacher {

    @NotNull
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    @Email(message = "邮箱错误")
    private String email;

    public Teacher() {
    }

    public Teacher(String name, Integer age, Boolean happy, Date birth, String email) {
        this.name = name;
        this.age = age;
        this.happy = happy;
        this.birth = birth;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                '}';
    }
}
