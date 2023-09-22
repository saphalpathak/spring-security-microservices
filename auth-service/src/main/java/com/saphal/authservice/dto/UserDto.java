package com.saphal.authservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.dto
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;

    private String fullName;

    private String phoneNumber;

    private String address;

    private String email;

    private String password;
}
