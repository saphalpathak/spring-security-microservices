package com.saphal.authservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.authservice.entity
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
@Entity
@Table(name = "users")
@Getter
@Setter
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Long id;

    private String fullName;

    private String phoneNumber;

    private String address;

    private String email;

    private String password;

}
