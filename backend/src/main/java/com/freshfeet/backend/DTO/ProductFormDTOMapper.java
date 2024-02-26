package com.freshfeet.backend.DTO;


import com.freshfeet.backend.model.*;
import com.freshfeet.backend.repository.ProductCategoryRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProductFormDTOMapper {

    @Autowired
    private ProductCategoryRepo productCategoryRepo;


    //Map Entity fields to DTO
    public ProductFormDTO mapToProductDTO(Product product, ProductItem productItem, String imgPath, ProductCategory category, List<VariationOption> options) {

        VariationOption variation1 = !options.isEmpty() ? options.get(0) : null;
        VariationOption variation2 = options.size() > 1 ? options.get(1) : null;
        VariationOption variation3 = options.size() > 2 ? options.get(2) : null;

        return new ProductFormDTO(
                category.getId(),
                product.getName(),
                product.getDescription(),
                imgPath,
                productItem.getSku(),
                variation1,
                variation2,
                variation3,
                productItem.getPrice(),
                productItem.getQtyInStock()
        );
    }

    // Map DTO to entity fields for Product
    public Product mapToProduct(ProductFormDTO dto){
        Product product = new Product();
        product.setName(dto.productName());
        product.setDescription(dto.description());
        // Check if product category id exists in product_category table before mapping it to Product instance
        Long catCheck = dto.categoryId();
        if (catCheck != null){
            ProductCategory catName = productCategoryRepo.findById(catCheck).orElseThrow(() -> new EntityNotFoundException("ProductCategory not found with ID: " + catCheck));
            product.setProductCategory(catName);
        }
        return product;
    }

    //Map DTO to ProductItems Entity fields
    public ProductItem mapToProductItem(ProductFormDTO dto, Product product){
        ProductItem productItem = new ProductItem();
        productItem.setSku(dto.SKU());
        productItem.setPrice(dto.price());
        productItem.setQtyInStock(dto.qtyInStock());
        productItem.setProduct(product);

        return productItem;
    }

    public List<ProductConfiguration> mapToProductConfiguration(ProductFormDTO dto){
        List<ProductConfiguration> variations = new ArrayList<ProductConfiguration>();
        if (dto.variation1() != null){
            ProductConfiguration productConfiguration1 = new ProductConfiguration();
            productConfiguration1.setVariationOption(dto.variation1());
            variations.add(productConfiguration1);
        }
        if (dto.variation2() != null){
            ProductConfiguration productConfiguration2 = new ProductConfiguration();
            productConfiguration2.setVariationOption(dto.variation2());
            variations.add(productConfiguration2);
        }
        if (dto.variation3() != null){
            ProductConfiguration productConfiguration3 = new ProductConfiguration();
            productConfiguration3.setVariationOption(dto.variation3());
            variations.add(productConfiguration3);
        }
        return variations;

    }

}
