package com.example.ecommercespring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/")
    public String home() {
        return "Welcome to E-Commerce Spring App 🚀";
    }
}
