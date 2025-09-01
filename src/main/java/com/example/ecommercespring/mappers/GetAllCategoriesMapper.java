package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.CategoryResponseDTO;

import java.util.List;

public class GetAllCategoriesMapper {


    public static List<CategoryDTO> CategoryResponseToCategoryMapper(CategoryResponseDTO categoryResponseDTO){

        return categoryResponseDTO.getCategories().stream().map(categories->CategoryDTO.builder().name(categories).build()).toList();

    }

}
