package com.freshfeet.backend.service;


import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.DTO.ProductFormDTOMapper;
import com.freshfeet.backend.model.ProductConfiguration;
import com.freshfeet.backend.repository.ProductConfigurationRepository;
import com.freshfeet.backend.repository.ProductItemRepository;
import com.freshfeet.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class ListingService {

    //Instantiate dto mapper, dto, product repo, productItem repo, productConfiguration repo to save these entities into
    //table

    @Autowired
    private ProductFormDTOMapper mapper;

    @Autowired
    private ProductFormDTO productFormDTO;


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductItemRepository productItemRepository;


    @Autowired
    private ProductConfigurationRepository productConfigurationRepository;










    }

