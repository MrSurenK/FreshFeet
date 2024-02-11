package com.freshfeet.backend.controller;

import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.oauth2.resourceserver.OAuth2ResourceServerSecurityMarker;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ListingService listingService;
    @PostMapping("/addProduct")
    @ResponseBody
    public ProductFormDTO addListing(@RequestBody ProductFormDTO productForm
                                     ){
        return listingService.createListing(productForm);
    }

}
