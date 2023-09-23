package com.saphal.blogservice.client;

import com.saphal.blogservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.blogservice.calls
 * @project treeleaf-demo
 * @since 2023-09-23, Saturday
 **/
@FeignClient("auth-service")
public interface AuthServiceClient {

    @GetMapping("/api/v1/user/{id}")
    ResponseEntity<UserDto> getUserByUserId(@PathVariable("id") Long id, @RequestHeader("Authorization") String token);

}
