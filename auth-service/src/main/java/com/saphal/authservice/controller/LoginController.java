package com.saphal.authservice.controller;

import com.saphal.authservice.dto.LoginRequestDto;
import com.saphal.authservice.dto.ResponseDto;
import com.saphal.authservice.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.controller
 * @project treeleaf-demo
 * @since 2023-09-23, Saturday
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class LoginController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<ResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequestDto.getEmail(), loginRequestDto.getPassword()
        ));
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse("Login successful",
                        jwtUtil.generateToken(loginRequestDto.getEmail()))
        );
    }

    @GetMapping("/validate")
    public boolean validateToken() {
        return true;
    }
}
