package com.example.ecommercespring.repository;

import com.example.ecommercespring.dto.ProductResponseDTO;
import com.example.ecommercespring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
}
