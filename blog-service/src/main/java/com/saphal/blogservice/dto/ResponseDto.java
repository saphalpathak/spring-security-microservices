package com.saphal.blogservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.blogservice.dto
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

    private String status;

    private String message;

    private Object data;


    public ResponseDto getSuccessResponse(String message, Object data) {
        this.message = message;
        this.data = data;
        this.status = "Success";
        return this;
    }

    public ResponseDto getErrorResponse(String message) {
        this.status="error";
        this.message = message;
        return this;

    }

}
