package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.entity.Product;
import com.example.ecommercespring.exceptions.CategoryNotFoundException;
import com.example.ecommercespring.mappers.CategoryMapper;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.ICategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.List;

@Service("dbservice")
public class CategoryService implements  ICategoryService{

    ICategoryRepository categoryRepository;
    CategoryService(ICategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @Override
    public List<CategoryDTO> getCategories() throws IOException {

        List<Category> category=categoryRepository.findAll();

        return category.stream().map(category1 -> CategoryMapper.todto(category1)).toList();

    }

    @Override
    public CategoryDTO createCategory(CategoryDTO category) throws IOException {
        Category category1=categoryRepository.save(CategoryMapper.toEntity(category));
        return CategoryMapper.todto(category1);
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long id) throws IOException {
          Category category=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("Category with ID " + id + " not found"));
          List<ProductDTO> products= category.getProducts().stream().map(product -> ProductMapper.todto(product)).toList();

          return AllProductsOfCategoryDTO.builder().categoryID(category.getId()).name(category.getName()).products(products).build();

    }


}
