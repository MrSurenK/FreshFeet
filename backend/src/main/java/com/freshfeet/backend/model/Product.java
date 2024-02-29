package com.freshfeet.backend.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Product {
//Fields
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long productId;

    private String name;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;


    private boolean isDiscontinued;


    @OneToMany(mappedBy = ProductItem_.PRODUCT) //(Mapped by refers to the owning side) and this is the inverse side
    private Set<ProductItem> productSKU;

    @ManyToOne(fetch=LAZY)
    private ProductCategory productCategory;


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

    public boolean getIsDiscontinued(){
        return this.isDiscontinued;
    }

    public void setIsDiscontinued(boolean isAvailable){
        this.isDiscontinued = isAvailable;
    }

    public Set<ProductItem> getProductSKU(){
        return productSKU;
    }

    //Helper method to add the SKU to the product(many-side) entity
    // No need for remove productSku as the database will not be deleting records
    public void setProductSku(ProductItem productSku){
        this.productSKU.add(productSku);
        productSku.setProduct(this); // This creates bi-directional relationship in the setter found in ProductItem
    }

    public ProductCategory getProductCategory(){
        return this.productCategory;
    }

    public void setProductCategory(ProductCategory productCategory){
        this.productCategory = productCategory;
    }
}
