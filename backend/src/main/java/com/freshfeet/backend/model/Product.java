package com.freshfeet.backend.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;


    private String name;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;

}
