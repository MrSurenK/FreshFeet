package com.freshfeet.backend.controller;

import com.freshfeet.backend.DTO.ProductFormDTO;
import com.freshfeet.backend.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ListingService listingService;
    @PostMapping("/addproduct")
    @ResponseBody
    //No need to check if productForm is not submitted because
    public ResponseEntity<Object> addListing(@RequestPart ProductFormDTO productForm,
                                             @RequestPart MultipartFile file
                                     ) throws IOException {
        if (file.isEmpty()){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Missing product image!");
        } else {
            ProductFormDTO updatedDto = listingService.createListing(productForm, file);
            return ResponseEntity.status(HttpStatus.OK).body("Product has been added!");
        }
    }
}

