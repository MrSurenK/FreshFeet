package com.freshfeet.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class ProductItem {

    @Id
    private String SKU; // SKU is the natural id for product item table

    private Integer qtyInStock;

    @Column(columnDefinition ="price", precision=8, scale=2 )
    private BigDecimal price;

}
