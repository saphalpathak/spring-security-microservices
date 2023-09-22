package com.saphal.authservice.repo;

import com.saphal.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.repo
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
