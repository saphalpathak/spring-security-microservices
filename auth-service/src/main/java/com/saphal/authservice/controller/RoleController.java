package com.saphal.authservice.controller;

import com.saphal.authservice.dto.ResponseDto;
import com.saphal.authservice.dto.RoleDto;
import com.saphal.authservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
 * @since 2023-09-22, Friday
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveRole(@RequestBody RoleDto roleDto) {
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "Role successfully saved.",
                        roleService.saveRole(roleDto)

                )
        );
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getAllRoles() {
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "Role successfully fetched.",
                        roleService.getAllRoles()

                )
        );


    }
}
