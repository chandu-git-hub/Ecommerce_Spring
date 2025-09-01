package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductResponseDTO;
import com.example.ecommercespring.gateway.api.IProductApi;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class FakeStoreProductGateway implements IProductGateway{

    private final IProductApi productApi;

    FakeStoreProductGateway(IProductApi productApi){
        this.productApi=productApi;
    }

    @Override
    public ProductDTO getProductsByID(Long id) throws IOException {

        ProductResponseDTO productresponse=productApi.getProductsByID(id).execute().body();

        if(productresponse == null){
            throw new IOException("Failed to fetch products from FakeStore API");
        }

        return productresponse.getProduct();

    }
}
