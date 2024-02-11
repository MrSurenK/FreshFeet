package com.freshfeet.backend.DTO;

import com.freshfeet.backend.model.ProductCategory;

import java.math.BigDecimal;

// Record will automatically generate getters
public record ProductFormDTO(
        String productName,
        ProductCategory productCategory,
        String description,
        String productImage,
        String SKU,
        BigDecimal price,
        Integer qtyInStock
) {

}
