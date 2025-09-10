package com.example.ecommercespring.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.services.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {


    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    //This mock mvc is useful to replicate scenario of Api call for the spring controller
    private MockMvc mockMvc;
    private CategoryDTO category1;
    private CategoryDTO category2;
    private CategoryDTO category3;
    private AllProductsOfCategoryDTO categoryProduct;
    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp(){
        mockMvc=MockMvcBuilders.standaloneSetup(categoryController).build();
        category1=CategoryDTO.builder().name("Electronics").build();
        category2=CategoryDTO.builder().name("Mobile").build();
        category3=CategoryDTO.builder().name("Laptop").build();
        categoryProduct=AllProductsOfCategoryDTO.builder().name("Electronics").categoryID(1L).products(new ArrayList<>()).build();
    }


    @Test
    @DisplayName("shouldGetCategoriesSucessfully")
    void getCategories_shouldGetCategories() throws Exception {
        //Arrange
        List<CategoryDTO> categoryDTOS=new ArrayList<>();
        categoryDTOS.add(category1);
        categoryDTOS.add(category2);
        categoryDTOS.add(category3);


        when(categoryService.getCategories()).thenReturn(categoryDTOS);

        //Act
        mockMvc.perform(get("/get/categories").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("Electronics"));

        verify(categoryService,times(1)).getCategories();

    }

    @Test
    @DisplayName("ShouldCreateCategorySucessfully")
    void createCategory_shouldCreateCategory() throws Exception {
        //Arrange
        when(categoryService.createCategory(any(CategoryDTO.class))).thenReturn(category1);
        //Act
        String json=mapper.writeValueAsString(category1);
        mockMvc.perform(post("/get/categories").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(jsonPath("$.name").value("Electronics"));
        verify(categoryService,times(1)).createCategory(any(CategoryDTO.class));

    }

    @Test
    void getAllCategoryProducts_shouldGetProductsOfaCategory() throws Exception {
        //Arrange
        when(categoryService.getAllProductsOfCategory(any(Long.class))).thenReturn(categoryProduct);
        Long id=1L;
        //Act
        mockMvc.perform(get("/get/categories/{id}/products",id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Electronics"));

        verify(categoryService,times(1)).getAllProductsOfCategory(any(Long.class));
    }



}
