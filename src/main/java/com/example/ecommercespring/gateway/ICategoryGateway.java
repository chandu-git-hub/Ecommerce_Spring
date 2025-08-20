package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    public List<CategoryDTO> getAllCategories() throws IOException;
}
