package com.freshfeet.backend.DTO;


import com.freshfeet.backend.model.Product;
import com.freshfeet.backend.model.ProductItem;
import org.springframework.stereotype.Component;

@Component
public class ProductFormDTOMapper {

    public ProductFormDTO mapToProductDTO(Product product, ProductItem productItem) {

        return new ProductFormDTO(
                product.getName(),
                product.getProductCategory(),
                product.getDescription(),
                product.getProductImage(),
                productItem.getSku(),
                productItem.getPrice(),
                productItem.getQtyInStock()
        );
    }

    public Product mapToProduct(ProductFormDTO dto) {
        Product product = new Product();
        product.setName(dto.productName());
        product.setProductCategory(dto.productCategory());
        product.setDescription(dto.description());
        product.setProductImage(dto.productImage());

        return product;

    }

    public ProductItem mapToProductItem(ProductFormDTO dto){

    }

}
