package com.example.ecommercespring.gateway.api;

import com.example.ecommercespring.dto.ProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IProductApi {

     @GET("products/{id}")
     Call<ProductResponseDTO> getProductsByID(@Path("id") Long id);
}
