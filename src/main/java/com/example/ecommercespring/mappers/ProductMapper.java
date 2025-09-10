package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductResponseDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductDTO product){

        return Product.builder()
                .color(product.getColor())
                .model(product.getModel())
                .brand(product.getBrand())
                .price(product.getPrice())
                .image(product.getImage())
                .title(product.getTitle())
                .description(product.getDescription())
                .popular(product.isPopular())
                .discount(product.getDiscount())
                .build();
    }

    public static ProductDTO todto(Product product){

        return ProductDTO.builder()
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
                .build();
    }
}
