package com.freshfeet.backend.service;

import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.DTO.ProductFormDTOMapper;
import com.freshfeet.backend.model.Product;
import com.freshfeet.backend.model.ProductCategory;
import com.freshfeet.backend.model.ProductItem;
import com.freshfeet.backend.model.VariationOption;
import com.freshfeet.backend.repository.ProductCategoryRepo;
import com.freshfeet.backend.repository.ProductConfigurationRepository;
import com.freshfeet.backend.repository.ProductItemRepository;
import com.freshfeet.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
    private VariationOption variationOption;

    @Autowired
    private ProductFormDTOMapper mapper;

    @Autowired
    private StorageService storageService;


    public ProductFormDTO createListing(ProductFormDTO dto, MultipartFile productImage) throws IOException {

        String imgPath = storageService.uploadProductImage(productImage);

        Product product = mapper.mapToProduct(dto);
        product.setProductImage(imgPath);

        ProductItem item = mapper.mapToProductItem(dto,product);

        List<VariationOption> variations = new ArrayList<VariationOption>();

        ProductCategory productCategory = new ProductCategory();

        ProductFormDTO updatedDto = mapper.mapToProductDTO(product, item, imgPath,productCategory,variations);

        product = productRepository.save(product);
        item = productItemRepository.save(item);

        return updatedDto;

    }

}
