package com.freshfeet.backend.DTO;
import com.freshfeet.backend.model.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class ProductFormDTOMapper {

    // Step1: Map the entity instances to the dto
    public ProductFormDTO mapFieldsToDTO(ProductCategory category, String productName, String description, String sku, String productImage, List<VariationOption> variations, BigDecimal price, Integer qtyInStock) {


        return new ProductFormDTO(
                category,
                productName,
                description,
                sku,
                productImage,
                variations,
                price,
                qtyInStock
        );


    }

    // Step 2:  Map the dto back to entity instances

    // Map dto Product fields to a new Product instance (In service layer check if product exists first)
    public Product mapDtoToProduct(ProductFormDTO dto){

        Product product = new Product();
        product.setProductCategory(dto.category());
        product.setName(dto.productName());
        product.setDescription(dto.description());

        return product;
    }

    //Map dto ProductItem fields to a new ProductItem instance (the sql link to product done in service layer)
    public ProductItem mapDtoToProductItem(ProductFormDTO dto){
        ProductItem productItem = new ProductItem();
        productItem.setSku(dto.sku());
        productItem.setProductImage(dto.productImage());
        productItem.setQtyInStock(dto.qtyInStock());
        productItem.setPrice(dto.price());

        return productItem;
    }


    //Map dto Variation fields to product configuration
    public List<ProductConfiguration> mapDtoToProductConfiguration(ProductFormDTO dto, ProductItem productItem){
        List<VariationOption> options = dto.variations();
        List<ProductConfiguration> configurations = new ArrayList<>();
        // Grab the instance for the product item and add variation option to it
        for (VariationOption eachVariation : options) {
            ProductConfiguration newConfiguration = new ProductConfiguration();
            newConfiguration.setProductItem(productItem);
            newConfiguration.setVariationOption(eachVariation);
            configurations.add(newConfiguration);
        }
        return configurations;

    }

}
