package com.andyron.mapper;

import com.andyron.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectUser();

    int addUser(User user);

    int deleteUser(int id);
}
