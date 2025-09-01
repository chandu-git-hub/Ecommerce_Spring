package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.CategoryResponseDTO;
import com.example.ecommercespring.gateway.api.ICategoryApi;
import com.example.ecommercespring.mappers.GetAllCategoriesMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{


    private final ICategoryApi categoryApi;

    FakeStoreCategoryGateway(ICategoryApi categoryApi){
        this.categoryApi=categoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        CategoryResponseDTO response= categoryApi.getCategories().execute().body();
        if(response == null){
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        return GetAllCategoriesMapper.CategoryResponseToCategoryMapper(response);


    }
}
