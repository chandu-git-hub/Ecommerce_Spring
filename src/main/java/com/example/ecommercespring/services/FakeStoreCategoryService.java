package com.example.ecommercespring.services;


import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {

    private final ICategoryGateway categoryGateway;

    FakeStoreCategoryService(@Qualifier("RestTemplateGateway") ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public List<CategoryDTO> getCategories() throws IOException {
        return categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO category) throws IOException {
        return null;
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long id) throws IOException {
        return null;
    }

}
