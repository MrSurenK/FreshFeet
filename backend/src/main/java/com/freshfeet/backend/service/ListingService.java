package com.freshfeet.backend.service;


import com.freshfeet.backend.model.ProductItem;
import com.freshfeet.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductItem productItem;

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Autowired
    private VariationRepository variationRepository;

    @Autowired
    private VariationOptionRepository variationOptionRepository;

    @Autowired
    private ProductConfigurationRepository productConfigurationRepository;






}
