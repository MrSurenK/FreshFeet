package com.freshfeet.backend.controller;


import com.freshfeet.backend.model.Product;
import com.freshfeet.backend.repository.ProductRepository;
import com.freshfeet.backend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path="product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorageService storageService;


    // Just a test controller. Refactor when implementing (File stored in folder and path in database)
    @PostMapping(path = "add")
    public @ResponseBody String addNewProduct(@RequestParam MultipartFile file, @RequestParam String name) throws IOException {
        Product n = new Product();
        n.setName(name);
        n.setProductImage(storageService.uploadProductImage(file));
        productRepository.save(n);

        return "Saved";
    }

}


