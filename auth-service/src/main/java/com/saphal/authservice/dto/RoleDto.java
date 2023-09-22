package com.saphal.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RoleDto {

    private Integer id;

    private String name;

    private String description;

}
