package com.freshfeet.backend.service;

import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.DTO.ProductFormDTOMapper;
import com.freshfeet.backend.model.*;
import com.freshfeet.backend.repository.ProductCategoryRepo;
import com.freshfeet.backend.repository.ProductConfigurationRepository;
import com.freshfeet.backend.repository.ProductItemRepository;
import com.freshfeet.backend.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ListingService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Autowired
    private ProductConfigurationRepository productConfigurationRepository;

    @Autowired
    private ProductFormDTOMapper mapper;

    @Autowired
    private StorageService storageService;


    public ProductFormDTO createListing(ProductFormDTO dto, MultipartFile productImage) throws IOException {

        String imgPath = storageService.uploadProductImage(productImage);

        Product product = mapper.mapToProduct(dto);
        product.setProductImage(imgPath);

        ProductItem item = mapper.mapToProductItem(dto,product);
        item = productItemRepository.save(item);

        ProductCategory productCategory = productCategoryRepo.findById(dto.categoryId()).orElseThrow(() -> new EntityNotFoundException("Can't find product category"));

        List<VariationOption> variationOptionList = new ArrayList<>();
        variationOptionList.add(dto.variation1());
        variationOptionList.add(dto.variation2());
        variationOptionList.add(dto.variation3());

        List<ProductConfiguration> productConfiguration = mapper.mapToProductConfiguration(dto, item);

        ProductFormDTO updatedDto = mapper.mapToProductDTO(product, item, imgPath,productCategory,variationOptionList);
        product = productRepository.save(product);


        return updatedDto;

    }

}
