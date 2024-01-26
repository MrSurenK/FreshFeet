package com.freshfeet.backend.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Set;

@Entity
public class Product {
//Fields
    @Id
    @GeneratedValue
    private Long productId;

    private String name;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    private String productImage;


    @OneToMany(mappedBy = ProductItem_.PRODUCT)
    private Set<ProductItem> productSKU;

    //Setters and Getters
    public Long getProductId(){
        return this.productId;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getProductImage(){
        return this.productImage;
    }

    public void setProductImage(String productImage){
        this.productImage = productImage;
    }

    public Set<ProductItem> getProductSKU(){
        return productSKU;
    }



}
