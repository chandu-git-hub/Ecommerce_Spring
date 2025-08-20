package com.example.ecommercespring.controllers;


import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.services.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/get/categories")
public class CategoryController {

    ICategoryService categoryService;

    CategoryController(ICategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getCategories() throws IOException {
        return categoryService.getCategories();
    }
}
