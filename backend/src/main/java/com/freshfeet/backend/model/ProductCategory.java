package com.freshfeet.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Long categoryId;

    private String category;


    public Long getCategoryId(){
        return this.categoryId;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
    }




}
