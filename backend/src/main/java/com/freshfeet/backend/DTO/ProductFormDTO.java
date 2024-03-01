package com.freshfeet.backend.DTO;

import com.freshfeet.backend.model.ProductCategory;
import com.freshfeet.backend.model.VariationOption;

import java.math.BigDecimal;
import java.util.List;

// Record will automatically generate getters
public record ProductFormDTO(
        ProductCategory category,
        String productName,
        String description,
        String sku,
        String productImage,
        //Can have up to 3 variations for each product
        List<VariationOption> variations,
        BigDecimal price,
        Integer qtyInStock
) {

}
