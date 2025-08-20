package com.example.ecommercespring.services;


import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService implements  ICategoryService {

    ICategoryGateway categoryGateway;

    CategoryService(ICategoryGateway categoryGateway){
        this.categoryGateway=categoryGateway;
    }
    public List<CategoryDTO> getCategories() throws IOException {
        return categoryGateway.getAllCategories();
    }

}
