package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    public List<CategoryDTO> getCategories() throws IOException;
    public CategoryDTO createCategory(CategoryDTO category) throws IOException;
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long id) throws IOException;
}
