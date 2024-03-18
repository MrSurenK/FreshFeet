package com.freshfeet.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freshfeet.backend.model.ProductCategory;
import com.freshfeet.backend.model.Variation;
import com.freshfeet.backend.model.VariationOption;
import com.freshfeet.backend.repository.ProductCategoryRepo;
import com.freshfeet.backend.repository.VariationOptionRepository;
import com.freshfeet.backend.repository.VariationRepository;
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
    private VariationRepository variationRepository;

    @Autowired
    private VariationOptionRepository variationOptionRepository;

    @Autowired
    private ListingService listingService;


    @GetMapping("/")
    public String dashboard(){
        return "dashboard";
    }
    // Thymeleaf add product page
    @GetMapping("/product/add")
    public String userForm(Model model) throws JsonProcessingException {
        //Allow thymeleaf to access ProductCategories object
        List<ProductCategory> categories = productCategoryRepo.findAll();
        //Allow thymeleaf to access variation object
        List<Variation> variations = variationRepository.findAll();
        // Allow thymeleaf to access all variation Option object
        List<VariationOption> variationOptions = variationOptionRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("variations", variations);
        model.addAttribute("variationOptions", variationOptions);
        return "addProductForm";
    }

}
