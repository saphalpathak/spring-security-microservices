package com.saphal.authservice.service;

import com.saphal.authservice.dto.RoleDto;

import java.util.List;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.service
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
public interface RoleService {

    RoleDto saveRole(RoleDto roleDto);

    List<RoleDto> getAllRoles();
}
