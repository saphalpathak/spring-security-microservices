package com.saphal.blogservice.service;

import com.saphal.blogservice.dto.BlogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.blogservice.service
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
public interface BlogService {
    BlogDto saveBlog(BlogDto blogDto);

    BlogDto updateBlog(BlogDto blogDto);

    List<BlogDto> getAllBlogs();

    BlogDto getBlogById(Long id);

    void deleteBlog(Long id);


}
