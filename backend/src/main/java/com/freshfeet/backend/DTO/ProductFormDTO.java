package com.freshfeet.backend.DTO;

import com.freshfeet.backend.model.ProductCategory;
import com.freshfeet.backend.model.VariationOption;

import java.math.BigDecimal;

// Record will automatically generate getters
public record ProductFormDTO(
        ProductCategory categoryId,
        String productName,
        String description,
        String SKU,
        String productImage,
        //Can have up to 3 variations for each product
        VariationOption firstVariation,
        VariationOption secondVariation,
        VariationOption thirdVariation,
        BigDecimal price,
        Integer qtyInStock
) {

}
