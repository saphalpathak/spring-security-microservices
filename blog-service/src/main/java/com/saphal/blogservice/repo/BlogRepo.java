package com.saphal.blogservice.repo;

import com.saphal.blogservice.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.blogservice.repo
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {

}
