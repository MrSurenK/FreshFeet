package com.freshfeet.backend.DTO;

import com.freshfeet.backend.model.ProductCategory;
import com.freshfeet.backend.model.VariationOption;

import java.math.BigDecimal;

// Record will automatically generate getters
public record ProductFormDTO(
        ProductCategory parentCategory,
        String subCategory,
        String productName,
        String description,
        String productImage,
        String SKU,
        //Can have up to 3 variations for each product
        VariationOption variation1,
        VariationOption variation2,
        VariationOption variation3,
        BigDecimal price,
        Integer qtyInStock
) {

}
