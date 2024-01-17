package com.freshfeet.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApp {

    @GetMapping("/welcome")
    public String test(){
        return "Welcome to Spring boot world!";
    }
}

