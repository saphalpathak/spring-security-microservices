package com.saphal.authservice.service;

import com.saphal.authservice.entity.Role;
import com.saphal.authservice.entity.User;
import com.saphal.authservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.service
 * @project treeleaf-demo
 * @since 2023-09-23, Saturday
 **/

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("Invalid credentials!!")
        );
        Role role = user.getRole();
        List<GrantedAuthority> simpleGrantedAuthorities = Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_".concat(role.getName())));
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), simpleGrantedAuthorities);
    }
}
