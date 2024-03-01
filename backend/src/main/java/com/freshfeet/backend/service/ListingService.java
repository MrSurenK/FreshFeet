package com.freshfeet.backend.service;


import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.DTO.ProductFormDTOMapper;
import com.freshfeet.backend.model.Product;
import com.freshfeet.backend.model.ProductCategory;
import com.freshfeet.backend.repository.ProductCategoryRepo;
import com.freshfeet.backend.repository.ProductConfigurationRepository;
import com.freshfeet.backend.repository.ProductItemRepository;
import com.freshfeet.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ListingService {

    //Instantiate dto mapper, category repo, product repo, productItem repo, productConfiguration repo to save these entities into
    //table

    @Autowired
    private ProductFormDTOMapper mapper;

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductItemRepository productItemRepository;


    @Autowired
    private ProductConfigurationRepository productConfigurationRepository;


    //Create a method that returns void to create listing in the controller of the app
    // The method should use the repositories to save the information input in the DTO and create the entities
    // The method should also take in as parameters the dto object and the product image file location

    public void createListing(ProductFormDTO productFormDTO, MultipartFile imageFile){

        // High level objective: From the deserialized dto object access the fields and pass into the respective objects

        /*
        Step 1: Map to Product entity and save to repository
        - For product category ensure that there is exception handling and validation check to ensure that the category id
        exists and if not throw and error
        - Ensure also that product does not already exist to prevent duplicate entries
         */

        Product productName = productRepository.findByName(productFormDTO.productName());
        Long checkCat = productFormDTO.category().getId();
        if (productName == null) {
            if (productCategoryRepo.findById(checkCat).isPresent()) {
                Product createProduct = mapper.mapDtoToProduct(productFormDTO);
                productRepository.save(createProduct);
            } else {
                throw new IllegalArgumentException("Category with ID" + checkCat + "not found");
            }
        } else {
            throw new DataIntegrityViolationException("Product with that name already exists!");
        }

        /*
        Step 2: Map to product Item entity and save to repository. Also deserialize file path to String and
        save to entity object.
         */

        //Step 3: Map to ProductConfiguration and save to repository.


    }












    }

