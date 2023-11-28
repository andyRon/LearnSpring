package com.andyron.sb02.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author andyron
 **/
@Data
@Builder
public class User {
    private long id;
    private String name;
    private int age;
}
