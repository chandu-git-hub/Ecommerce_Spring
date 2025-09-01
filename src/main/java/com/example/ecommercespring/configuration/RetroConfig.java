package com.example.ecommercespring.configuration;

import com.example.ecommercespring.gateway.IProductGateway;
import com.example.ecommercespring.gateway.api.ICategoryApi;
import com.example.ecommercespring.gateway.api.IProductApi;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

@Configuration
public class RetroConfig {

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public ICategoryApi getCategories(Retrofit retrofit){
        return retrofit.create(ICategoryApi.class);
    }

    @Bean
    public IProductApi getProductsByID(Retrofit retrofit){
        return retrofit.create(IProductApi.class);
    }
}
