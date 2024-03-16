package com.freshfeet.backend.controller;

import com.freshfeet.backend.model.ProductCategory;
import com.freshfeet.backend.repository.ProductCategoryRepo;
import com.freshfeet.backend.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Autowired
    private ListingService listingService;


    @GetMapping("/")
    public String dashboard(){
        return "dashboard";
    }
    // Thymeleaf add product page
    @GetMapping("/product/add")
    public String userForm(Model model){
        List<ProductCategory> categories = productCategoryRepo.findAll();
        model.addAttribute("categories", categories);
        return "addProductForm";
    }

}
