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

    private String productImage;


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
    public Long getProductId(){
        return this.productId;
    }



    public String getProductImage(){
        return this.productImage;
    }

    public void setProductImage(String productImage){
        this.productImage = productImage;
    }

}
