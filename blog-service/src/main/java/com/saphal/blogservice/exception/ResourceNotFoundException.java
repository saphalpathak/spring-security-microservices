package com.saphal.blogservice.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.blogservice.exception
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
