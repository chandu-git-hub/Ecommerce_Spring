package com.example.ecommercespring.controllers;


import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.exceptions.CategoryNotFoundException;
import com.example.ecommercespring.services.ICategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/get/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    CategoryController(@Qualifier("dbservice") ICategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getCategories() throws IOException {
        return categoryService.getCategories();
    }

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO category) throws IOException {
        return categoryService.createCategory(category);
    }

    @GetMapping("/{id}/products")
    public AllProductsOfCategoryDTO getAllCategoryproducts(@PathVariable("id") Long id) throws IOException{
        return categoryService.getAllProductsOfCategory(id);
    }


}
