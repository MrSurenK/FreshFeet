package com.freshfeet.backend.controller;

import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ListingService listingService;
    @PostMapping("/addProduct")
    @ResponseBody
    public ResponseEntity<Object> addListing(@RequestPart ProductFormDTO productForm,
                                             @RequestPart MultipartFile file
                                     ) throws IOException { ProductFormDTO updatedDto = listingService.createListing(productForm, file);
        return ResponseEntity.ok(updatedDto);

    }
}
