package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.entity.Product;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    public ProductDTO getProductsByID(Long id) throws IOException;
    public ProductDTO createProduct(ProductDTO product) throws IOException;
    public ProductWithCategoryDTO getProductsWithCategory(Long id) throws IOException;
    public List<ProductDTO> getProductsWithIds(List<Long> ids);
}
