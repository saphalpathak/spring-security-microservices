package com.saphal.authservice.controller;

import com.saphal.authservice.dto.ResponseDto;
import com.saphal.authservice.dto.UserDto;
import com.saphal.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.controller
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "User successfully saved.",
                        userService.saveUser(userDto)

                )
        );
    }

    @PutMapping
    public ResponseEntity<ResponseDto> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "User successfully updated.",
                        userService.updateUser(userDto)

                )
        );
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getAllUsers() {
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "User successfully fetched.",
                        userService.getAllUsers()

                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "User successfully fetched.",
                        userService.getUserById(id)

                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "User successfully deleted.",
                        null
                )
        );
    }
}
