package com.devbook.formattech.service;

import com.devbook.formattech.Dto.UserDto;
import com.devbook.formattech.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser (UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(int id);
    UserDto updateUser(int id, UserDto userDto);
    User deleteUser(int id);

}
