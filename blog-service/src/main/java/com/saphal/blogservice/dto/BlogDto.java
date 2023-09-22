package com.saphal.blogservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.blogservice.dto
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/

@Getter
@Setter
@Accessors(chain = true)
public class BlogDto {

    private Long id;

    private String title;

    private LocalDateTime publishedDateTime;

    private String body;

    private Long author;

}
