package com.saphal.authservice.mapper;

import com.saphal.authservice.dto.RoleDto;
import com.saphal.authservice.dto.UserDto;
import com.saphal.authservice.entity.Role;
import com.saphal.authservice.entity.User;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.mapper
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
public class UserMapper {

    public static User mapDtoToEntity(UserDto userDto) {
        return new User()
                .setId(userDto.getId())
                .setEmail(userDto.getEmail())
                .setAddress(userDto.getAddress())
                .setPassword(userDto.getPassword())
                .setFullName(userDto.getFullName())
                .setPhoneNumber(userDto.getPhoneNumber());
    }

    public static UserDto mapEntityToDto(User user) {
        Role role = user.getRole();
        return new UserDto()
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setAddress(user.getAddress())
                .setPassword(user.getPassword())
                .setFullName(user.getFullName())
                .setPhoneNumber(user.getPhoneNumber())
                .setRole(new RoleDto(role.getId(), role.getName(), role.getDescription()));
    }
}
