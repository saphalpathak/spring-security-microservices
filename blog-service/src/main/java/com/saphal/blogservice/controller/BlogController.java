package com.saphal.blogservice.controller;

import com.saphal.blogservice.dto.BlogDto;
import com.saphal.blogservice.dto.ResponseDto;
import com.saphal.blogservice.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.blogservice.controller
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveBlog(@RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "Blog successfully saved.",
                        blogService.saveBlog(blogDto)
                )
        );
    }

    @PutMapping
    public ResponseEntity<ResponseDto> updateBlog(@RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "Blog successfully updated.",
                        blogService.updateBlog(blogDto)
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "Blog successfully fetched.",
                        blogService.getBlogById(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getAllBlog() {
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "Blog successfully fetched.",
                        blogService.getAllBlogs()
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteBlogById(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok(
                new ResponseDto().getSuccessResponse(
                        "Blog successfully deleted.",
                        null
                )
        );
    }


}
