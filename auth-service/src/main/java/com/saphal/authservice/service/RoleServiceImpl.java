package com.saphal.authservice.service;

import com.saphal.authservice.dto.RoleDto;
import com.saphal.authservice.entity.Role;
import com.saphal.authservice.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
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
public class RoleServiceImpl implements RoleService {

    private final RoleRepo repo;

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        Role role = new Role(roleDto.getId(), roleDto.getName(), roleDto.getDescription());
        repo.save(role);
        return new RoleDto(role.getId(), role.getName(), role.getDescription());
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> allRole = repo.findAll();
        return allRole.stream().map(role -> new RoleDto(role.getId(), role.getName(), role.getDescription())).toList();
    }
}
