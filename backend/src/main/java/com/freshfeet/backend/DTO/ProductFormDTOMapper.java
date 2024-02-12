package com.freshfeet.backend.DTO;


import com.freshfeet.backend.model.Product;
import com.freshfeet.backend.model.ProductItem;
import org.springframework.stereotype.Component;


@Component
public class ProductFormDTOMapper {


    //Map Entity fields to DTO
    public ProductFormDTO mapToProductDTO(Product product, ProductItem productItem, String imgPath) {

        return new ProductFormDTO(
                product.getName(),
                product.getDescription(),
                imgPath,
                productItem.getSku(),
                productItem.getPrice(),
                productItem.getQtyInStock()
        );
    }

    // Map DTO to entity fields for Product
    public Product mapToProduct(ProductFormDTO dto){
        Product product = new Product();
        product.setName(dto.productName());
        product.setDescription(dto.description());
        product.setProductImage(dto.productImage());
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

}
