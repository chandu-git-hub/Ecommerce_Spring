package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class FakeStoreProductService implements IProductService{

    private final IProductGateway productGateway;

    FakeStoreProductService(IProductGateway productGateway){
        this.productGateway=productGateway;
    }

    @Override
    public ProductDTO getProductsByID(Long id) throws IOException {
        return productGateway.getProductsByID(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) throws IOException {
        return null;
    }

    @Override
    public ProductWithCategoryDTO getProductsWithCategory(Long id) throws IOException {
        return null;
    }

    @Override
    public List<ProductDTO> getProductsWithIds(List<Long> ids) {
        return List.of();
    }

}
