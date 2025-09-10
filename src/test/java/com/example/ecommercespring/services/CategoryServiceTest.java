package com.example.ecommercespring.services;


import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//The main goal of the mokito is to avoid DB calls
@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    CategoryDTO category;
    Category category1;
    Category category2;
    Category category3;
    @BeforeEach
    void setUp(){
        category1=Category.builder().name("Electronics").build();
        category1.setId(1L);
        category2=Category.builder().name("Mobile").build();
        category1.setId(2L);
        category3=Category.builder().name("Laptop").build();
        category1.setId(3L);
        category=CategoryDTO.builder().name("Electronics").build();

    }
    @Test
    @DisplayName("Should Return All The Categories Sucessfully")
    void getCategories_shouldReturnAllCategories() throws IOException {
        //Arrange -- Creating Mock Data
        List<Category> categories=new ArrayList<>();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        when(categoryRepository.findAll()).thenReturn(categories);


        //Act -- Call the Actual method and specify the return values
        List<CategoryDTO> categoryDTOS=categoryService.getCategories();

        //Assert -- Assert the result
        assertEquals(categoryDTOS.size(),3);
        verify(categoryRepository,times(1)).findAll();


    }

    @Test
    @DisplayName("Should Create Category Sucessfully")
    void createCategory_shouldCreateCategory() throws IOException {
        //Arrange -- Observe the output of the real method and mock the same
        when(categoryRepository.save(any(Category.class))).thenReturn(category1);
        //Act
        CategoryDTO categoryDTO=categoryService.createCategory(category);
        //Assert
        assertEquals(categoryDTO.getName(),"Electronics");
    }
}
