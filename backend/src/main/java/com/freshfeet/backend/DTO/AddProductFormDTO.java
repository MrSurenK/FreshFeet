package com.freshfeet.backend.DTO;

import java.math.BigDecimal;

// Record will automatically generate getters
public record AddProductFormDTO(
         String ProductName,
         String description,
         String productImage,

         String productCategory,

         String SKU,

         BigDecimal price,

         Integer qtyInStock
) {

}
