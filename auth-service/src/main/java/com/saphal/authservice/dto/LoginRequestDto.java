package com.saphal.authservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.dto
 * @project treeleaf-demo
 * @since 2023-09-23, Saturday
 **/

@Getter
@Setter
public class LoginRequestDto {

    private String email;

    private String password;
}
