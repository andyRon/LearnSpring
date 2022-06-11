package com.andyron;

import com.andyron.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private Dog dog;

    @Autowired
    Student student;

    @Autowired
    Boss boss;

    @Autowired
    Teacher teacher;
    @Test
    void contextLoads() {
//        System.out.println(person);
//        System.out.println(dog);
//        System.out.println(student);
//        System.out.println(boss);
        System.out.println(teacher);
    }

}
