package com.freshfeet.backend.service;

import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.DTO.ProductFormDTOMapper;
import com.freshfeet.backend.model.Product;
import com.freshfeet.backend.model.ProductItem;
import com.freshfeet.backend.repository.ProductItemRepository;
import com.freshfeet.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ListingService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private ProductFormDTOMapper mapper;

    @Autowired
    private StorageService storageService;


    public ProductFormDTO createListing(ProductFormDTO dto, MultipartFile productImage) throws IOException {

        String imgPath = storageService.uploadProductImage(productImage);

        Product product = mapper.mapToProduct(dto);
        product.setProductImage(dto.productImage());

        ProductItem item = mapper.mapToProductItem(dto,product);

        ProductFormDTO updatedDto = mapper.mapToProductDTO(product, item, imgPath);
        product = productRepository.save(product);
        item = productItemRepository.save(item);


        return updatedDto;

    }

}
