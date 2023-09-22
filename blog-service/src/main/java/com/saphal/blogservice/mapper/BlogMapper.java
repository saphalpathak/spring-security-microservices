package com.saphal.blogservice.mapper;

import com.saphal.blogservice.dto.BlogDto;
import com.saphal.blogservice.entity.Blog;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.blogservice.mapper
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
public class BlogMapper {
    public static Blog mapDtoToEntity(BlogDto blogDto) {
        return new Blog()
                .setId(blogDto.getId())
                .setBody(blogDto.getBody())
                .setTitle(blogDto.getTitle())
                .setAuthor(blogDto.getAuthor())
                .setPublishedDateTime(blogDto.getPublishedDateTime());
    }

    public static BlogDto mapEntityToDto(Blog blog) {
        return new BlogDto()
                .setId(blog.getId())
                .setBody(blog.getBody())
                .setTitle(blog.getTitle())
                .setAuthor(blog.getAuthor())
                .setPublishedDateTime(blog.getPublishedDateTime());

    }
}
