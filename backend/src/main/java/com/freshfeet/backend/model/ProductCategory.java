package com.freshfeet.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Long productCatId;
    

}
