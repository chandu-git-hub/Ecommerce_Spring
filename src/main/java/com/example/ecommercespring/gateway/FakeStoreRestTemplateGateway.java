package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.CategoryResponseDTO;
import com.example.ecommercespring.mappers.GetAllCategoriesMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("RestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway {

    private final RestTemplate restTemplate;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate=restTemplateBuilder.build();
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        CategoryResponseDTO categoryResponseDTO = restTemplate.getForObject("https://fakestoreapi.in/api/products/category", CategoryResponseDTO.class);
        return GetAllCategoriesMapper.CategoryResponseToCategoryMapper(categoryResponseDTO);
    }
}
