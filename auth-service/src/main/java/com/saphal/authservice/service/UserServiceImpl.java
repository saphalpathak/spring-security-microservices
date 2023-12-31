package com.saphal.authservice.service;

import com.saphal.authservice.dto.UserDto;
import com.saphal.authservice.entity.Role;
import com.saphal.authservice.entity.User;
import com.saphal.authservice.exception.ResourceNotFoundException;
import com.saphal.authservice.mapper.UserMapper;
import com.saphal.authservice.repo.RoleRepo;
import com.saphal.authservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.service
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto saveUser(UserDto userDto) {
        Role role = roleRepo.findById(userDto.getRoleId()).orElseThrow(
                () -> new ResourceNotFoundException("Role not found.")
        );
        User user = UserMapper.mapDtoToEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(role);
        userRepo.save(user);
        return UserMapper.mapEntityToDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepo.findById(userDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User not found.")
        );
        user.setPhoneNumber(userDto.getPhoneNumber())
                .setEmail(userDto.getEmail())
                .setAddress(userDto.getAddress())
                .setPassword(passwordEncoder.encode(userDto.getPassword()))
                .setFullName(userDto.getFullName());
        userRepo.save(user);
        return UserMapper.mapEntityToDto(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found.")
        );
        return UserMapper.mapEntityToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUser = userRepo.findAll();
        return allUser.stream().map(
                UserMapper::mapEntityToDto
        ).toList();
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found.")
        );
        userRepo.delete(user);
    }
}
