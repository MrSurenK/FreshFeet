package com.freshfeet.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {
    // Thymeleaf add product page
    @GetMapping("/")
    public String userForm(Model model){
        model.addAttribute("message", "Add product page");
        return "addProductForm";
    }

}
