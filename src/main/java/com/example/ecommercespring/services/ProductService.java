package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductResponseDTO;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.entity.Product;
import com.example.ecommercespring.exceptions.ProductNotFoundException;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.mappers.ProductWithcategoryMapper;
import com.example.ecommercespring.repository.IProductRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.List;

@Service("DBService")
public class ProductService implements IProductService{

    IProductRepository productRepository;

    ProductService(IProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public ProductDTO getProductsByID(Long id) throws IOException {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));

        return ProductMapper.todto(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) throws IOException {
        Product product1=productRepository.save(ProductMapper.toEntity(product));
        return ProductMapper.todto(product1);
    }


    @Override
    public ProductWithCategoryDTO getProductsWithCategory(Long id) throws IOException {

        Product product=productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product with ID " + id + " not found"));

        return ProductWithcategoryMapper.todto(product);

    }

    @Override
    public List<ProductDTO> getProductsWithIds(List<Long> ids) {
        List<Product> products=productRepository.findAllById(ids);
        return products.stream().map(product -> ProductMapper.todto(product)).toList();
    }




}
