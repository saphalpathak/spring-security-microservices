package com.saphal.blogservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @JsonProperty("data")
    private Data data;

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private String status;
}