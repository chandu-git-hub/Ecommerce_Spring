package com.example.ecommercespring.controllers;


import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.exceptions.CategoryNotFoundException;
import com.example.ecommercespring.exceptions.ProductNotFoundException;
import com.example.ecommercespring.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/get/products")
public class ProductController {

    private final IProductService productService;

    ProductController(@Qualifier("DBService") IProductService productService){
        this.productService=productService;
    }
    @GetMapping("{id}")
    public ProductDTO getProductsByID(@PathVariable Long id) throws IOException {
        return productService.getProductsByID(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO product) throws  IOException{
        return productService.createProduct(product);
    }

    @GetMapping("/{id}/details")
    public ProductWithCategoryDTO getProductsWithCategory(@PathVariable("id") Long id) throws IOException {
        return productService.getProductsWithCategory(id);
    }

    @PostMapping("/batch")
    public List<ProductDTO> getAllProductsWithId(@RequestBody List<Long> ids){
        return productService.getProductsWithIds(ids);
    }

}
