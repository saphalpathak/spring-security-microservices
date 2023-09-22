package com.saphal.blogservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.blogservice.entity
 * @project treeleaf-demo
 * @since 2023-09-22, Friday
 **/
@Entity
@Table(name = "blog")
@Getter
@Setter
@Accessors(chain = true)
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_id_seq")
    @SequenceGenerator(name = "blog_id_seq", sequenceName = "blog_id_seq", allocationSize = 1)
    private Long id;

    private String title;

    private LocalDateTime publishedDateTime;

    private String body;

    private Long author;
}
