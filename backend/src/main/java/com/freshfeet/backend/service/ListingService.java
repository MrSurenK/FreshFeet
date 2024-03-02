package com.freshfeet.backend.service;


import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.DTO.ProductFormDTOMapper;
import com.freshfeet.backend.model.*;
import com.freshfeet.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class ListingService {

    /*Instantiate dto mapper, category repo, product repo, productItem repo, productConfiguration repo to save these
      entities into table
    */
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

    @Autowired
    private VariationRepository variationRepository;

    @Autowired
    private VariationOptionRepository variationOptionRepository;

    @Autowired
    private StorageService storageService;




    //Create a method that returns void to create listing in the controller of the app
    // The method should use the repositories to save the information input in the DTO and create the entities
    // The method should also take in as parameters the dto object and the product image file location

    public void createListing(ProductFormDTO productFormDTO, MultipartFile imageFile) throws Exception {

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
                try {
                     productRepository.save(createProduct);
                } catch (Exception e){
                    throw new RuntimeException("Error while saving the product: " + e.getMessage());
                }
            } else {
                throw new IllegalArgumentException("Category with ID" + checkCat + "not found");
            }
        } else {
            throw new DataIntegrityViolationException("Product with that name already exists!");
        }

        /*
        Step 2: Map to product item entity and save to repository. Also deserialize file path to String and
        save to entity object.
        - Ensure that no duplicate SKUs and as such same object are created (done)
        - Check if product exists (done)
        - Ensure that SKU keyed in DTO is a valid format (regex) and is not a duplicate (done)
         https://www.youtube.com/watch?v=sCuOJ8uadOg
        - Ensure that price is not negative (done)
        - Ensure image location is converted as a string and set into the entity instance (done)
         */
        String checkSku = productFormDTO.sku();
        ProductItem sku = null;
        boolean skuExistence = productItemRepository.findById(checkSku).isPresent();
        if (skuExistence){
            throw new Exception("This SKU already exists!");
        }

        Product createdProduct = productRepository.findByName(productFormDTO.productName());

        if(createdProduct == null){
            throw new Exception("Product model does not exist");
        }

        if (!checkSkuPattern(checkSku)){
            throw new IllegalArgumentException("The SKU does not meet its standards!");
        }

        BigDecimal price = productFormDTO.price();
        if (isNullOrZero(price)){
            throw new IllegalArgumentException("Price cannot be null or zero!");
        }

        String imageDirectory = storageService.uploadProductImage(imageFile);

        ProductItem createProductItem = mapper.mapDtoToProductItem(productFormDTO);
        createProductItem.setProductImage(imageDirectory);
        // if all the conditions above are met then save the productItem entity
        try {
            productItemRepository.save(createProductItem);
            sku = createProductItem;
        } catch (Exception e){
            throw new RuntimeException("Error while saving the product item: " + e.getMessage());
        }

        /*Step 3: Map to ProductConfiguration and save to repository.
            - Get the id of the productItem created above (done)
            - For each variationOption create a new product Configuration instance and add the
              productItem id in it
            - Check if variation Options id exists in the array exists in table if it does not throw an exception
                - Make sure to use id as there are similarly named variation options
                - Check that category id found in product exists in variation entity
        */
        List<VariationOption> options = productFormDTO.variations();
        for(VariationOption option: options) {
            // Check if variation option exists in variation option entity
            Optional<VariationOption> existingOption = variationOptionRepository.findById(option.getId());
            if (existingOption.isPresent()) {
                VariationOption foundOption = existingOption.get();
                Variation variation = foundOption.getVariation();
                if (variation != null) {
                    ProductCategory category = variation.getCategory();
                    if (category != null && category.getId().equals(checkCat)) {
                        ProductConfiguration newConfiguration = new ProductConfiguration();
                        newConfiguration.setProductItem(sku);
                        newConfiguration.setVariationOption(option);
                        productConfigurationRepository.save(newConfiguration);
                    } else {
                        // The linkage is incorrect
                        throw new IllegalArgumentException("Incorrect category linkage");
                    }
                } else {
                    // The VariationOption is not linked to any Variation
                    throw new IllegalArgumentException("Option not linked to any Variation");
                }
            } else {
                // The VariationOption does not exist
                throw new IllegalArgumentException("Option does not exist");
            }
        }
    }



    public static boolean checkSkuPattern(String sku){
        Pattern pattern = Pattern.compile("SKU-[A-Z]{4}[A-Z]{3}(\\d{2}|[A-Z])");
        Matcher matcher = pattern.matcher(sku);

        return matcher.find();
    }

    public static boolean isNullOrZero(BigDecimal number){
        boolean isBigDecimalValueNullOrZero = false;
        if (number == null){
            isBigDecimalValueNullOrZero = true;
        }
        else if (number.compareTo(BigDecimal.ZERO) == 0){
            isBigDecimalValueNullOrZero = true;
        }
        return isBigDecimalValueNullOrZero;
    }


}

