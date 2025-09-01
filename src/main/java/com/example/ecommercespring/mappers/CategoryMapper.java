package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryDTO category){

        return Category.builder().name(category.getName()).build();
    }

    public static CategoryDTO todto(Category category){
        return CategoryDTO.builder().name(category.getName()).build();
    }
}
