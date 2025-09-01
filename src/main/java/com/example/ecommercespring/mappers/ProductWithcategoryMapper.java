package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.entity.Product;

public class ProductWithcategoryMapper {

    public static ProductWithCategoryDTO todto(Product product){
        return ProductWithCategoryDTO.builder()
                .id(product.getId())
                .color(product.getColor())
                .model(product.getModel())
                .brand(product.getBrand())
                .price(product.getPrice())
                .image(product.getImage())
                .title(product.getTitle())
                .categoryId(product.getCategory().getId())
                .description(product.getDescription())
                .popular(product.isPopular())
                .discount(product.getDiscount())
                .category(CategoryMapper.todto(product.getCategory()))
                .build();
    }
}
