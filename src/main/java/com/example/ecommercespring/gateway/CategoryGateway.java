package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.CategoryResponseDTO;
import com.example.ecommercespring.gateway.api.ICategoryApi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Component
public class CategoryGateway implements ICategoryGateway{


    ICategoryApi categoryApi;

    CategoryGateway(ICategoryApi categoryApi){
        this.categoryApi=categoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        CategoryResponseDTO response= categoryApi.getCategories().execute().body();
        if(response == null){
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        return response.getCategories().stream().map(Category->CategoryDTO.builder().name(Category).build()).toList();


    }
}
