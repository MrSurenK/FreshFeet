package com.freshfeet.backend.controller;

import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ListingService listingService;
    @PostMapping("/addproduct")
    @ResponseBody
    public ResponseEntity<Object> addListing(@RequestPart ProductFormDTO productForm,
                                             @RequestPart MultipartFile file
                                     ) throws IOException {
        if (productForm != null && !file.isEmpty()){
            ProductFormDTO updatedDto = listingService.createListing(productForm, file);
            return ResponseEntity.accepted().body("Product has been added!");
        } else {
            return ResponseEntity.badRequest().body("Missing form items");
        }

    }
}
