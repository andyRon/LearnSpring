package com.andyron.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
// javaconfig 绑定配置文件的值，可采取这种方式
// 加载指定的配置文件
@PropertySource(value = "classpath:student.properties")
public class Student {
    // SpEl表达式
    @Value("${id}")
    long id;
    @Value("${name}")
    String name;
    @Value("${score}")
    Double score;

    public Student() {
    }

    public Student(long id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
