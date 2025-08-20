package com.example.ecommercespring.configuration;

import com.example.ecommercespring.gateway.api.ICategoryApi;
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
}
