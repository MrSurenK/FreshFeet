package com.freshfeet.backend.service;

import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.DTO.ProductFormDTOMapper;
import com.freshfeet.backend.model.Product;
import com.freshfeet.backend.model.ProductItem;
import com.freshfeet.backend.repository.ProductItemRepository;
import com.freshfeet.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private ProductFormDTOMapper mapper;


    public ProductFormDTO createListing(ProductFormDTO dto) {
        Product product = mapper.mapToProduct(dto);
        ProductItem item = mapper.mapToProductItem(dto,product);

        product = productRepository.save(product);
        item = productItemRepository.save(item);

        return dto;

    }

}
