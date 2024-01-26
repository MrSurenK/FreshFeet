package com.freshfeet.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.NaturalId;

import java.math.BigDecimal;

@Entity
public class ProductItem {

//    @Id
//    @GeneratedValue
//    private Integer id;

    @Id
    private String SKU; // SKU is the natural id for product item table

    private Integer qtyInStock;

    @Column(precision=8, scale=2 )
    private BigDecimal price;

}
