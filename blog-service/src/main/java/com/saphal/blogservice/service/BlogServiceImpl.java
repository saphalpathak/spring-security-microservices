package com.saphal.blogservice.service;

import com.saphal.blogservice.dto.BlogDto;
import com.saphal.blogservice.entity.Blog;
import com.saphal.blogservice.exception.ResourceNotFoundException;
import com.saphal.blogservice.mapper.BlogMapper;
import com.saphal.blogservice.repo.BlogRepo;
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
@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepo blogRepo;

    @Override
    public BlogDto saveBlog(BlogDto blogDto) {
        Blog blog = BlogMapper.mapDtoToEntity(blogDto);
        blogRepo.save(blog);
        return BlogMapper.mapEntityToDto(blog);
    }

    @Override
    public BlogDto updateBlog(BlogDto blogDto) {
        Blog blog = blogRepo.findById(blogDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Blog not found.")
        );
        blog.setBody(blogDto.getBody())
                .setTitle(blogDto.getTitle())
                .setAuthor(blogDto.getAuthor())
                .setPublishedDateTime(blogDto.getPublishedDateTime());
        blogRepo.save(blog);
        return BlogMapper.mapEntityToDto(blog);
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        List<Blog> allBlog = blogRepo.findAll();
        return allBlog.stream().map(BlogMapper::mapEntityToDto).toList();
    }

    @Override
    public BlogDto getBlogById(Long id) {

        Blog blog = blogRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Blog not found.")
        );
        return BlogMapper.mapEntityToDto(blog);
    }

    @Override
    public void deleteBlog(Long id) {
        Blog blog = blogRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Blog not found.")
        );

        blogRepo.delete(blog);

    }
}
