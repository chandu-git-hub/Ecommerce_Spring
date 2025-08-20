package com.example.ecommercespring.gateway.api;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.CategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;


public interface ICategoryApi {

    @GET("products/category")
    Call<CategoryResponseDTO> getCategories();
}
