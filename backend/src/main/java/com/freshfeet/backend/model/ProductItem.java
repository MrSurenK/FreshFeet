package com.freshfeet.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ProductItem {

    // Fields
    @Id
    private String Sku; // SKU is the natural id for product item table

    private Integer qtyInStock;

    @Column(precision=8, scale=2 )
    private BigDecimal price;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_product_id") //Foreign Key name (Owning side)
    private Product product;

    private


    //Setters and Getters
    public String getSku(){
        return this.Sku;
    }

    public void setSku(String Sku){
        this.Sku = Sku;
    }

    public Integer getQtyInStock(){
        return this.qtyInStock;
    }

    public void setQtyInStock(Integer qtyInStock){
        this.qtyInStock = qtyInStock;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public Product getProduct(){
        return this.product;
    }

    public void setProduct(Product product){
        this.product = product;
    }


}
