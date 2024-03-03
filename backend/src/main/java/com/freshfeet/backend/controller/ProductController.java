package com.freshfeet.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "This is going to be a sidebar");
        return "sidebar"; // This will render sidebar.html Thymeleaf template
    }

}
