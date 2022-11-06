package com.example.coursework.service;

import com.example.coursework.dto.UserDto;
import com.example.coursework.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
