package com.freshfeet.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private Integer quantity;

    @Column(precision = 8, scale = 2)
    private BigDecimal price;


    //Setters and Getters
    public Long getId(){
        return this.id;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }





}
