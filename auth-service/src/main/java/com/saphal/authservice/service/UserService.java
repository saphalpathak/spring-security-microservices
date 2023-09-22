package com.saphal.authservice.service;

import com.saphal.authservice.dto.UserDto;

import java.util.List;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.service
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
public interface UserService {
    UserDto saveUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    void deleteUser(Long id);

}
