package com.freshfeet.backend.model;

import jakarta.persistence.*;

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


    @OneToMany(mappedBy = ProductItem_.PRODUCT) //(Mapped by refers to the owning side) and this is the inverse side
    private Set<ProductItem> productSKU;

    @OneToMany(mappedBy = PromotionCategory_.PROMOTION_ID)
    private Set<PromotionCategory> promotionId;

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

    public void setProductSKU(Set<ProductItem>productSKU){
        this.productSKU = productSKU;
    }

    //Helper method to add the SKU to the product(many-side) entity
    // No need for remove productSku as the database will not be deleting records
    public void addProductSku(ProductItem productSku){
        this.productSKU.add(productSku);
        productSku.setProduct(this);
    }

}
