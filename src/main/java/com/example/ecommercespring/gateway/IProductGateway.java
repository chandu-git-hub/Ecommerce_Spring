package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    public ProductDTO getProductsByID(Long id) throws IOException;
}
