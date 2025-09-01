package com.example.ecommercespring.repository;

import com.example.ecommercespring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
