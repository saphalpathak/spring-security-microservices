package com.saphal.blogservice.exception;

import com.saphal.blogservice.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.blogservice.exception
 * @project treeleaf-demo
 * @since 2023-09-23, Saturday
 **/
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ResponseDto> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        return new ResponseEntity<>(
                new ResponseDto().getErrorResponse(resourceNotFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ResponseDto> handleRunTimeException(RuntimeException runtimeException) {
        return new ResponseEntity<>(
                new ResponseDto().getErrorResponse(runtimeException.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
