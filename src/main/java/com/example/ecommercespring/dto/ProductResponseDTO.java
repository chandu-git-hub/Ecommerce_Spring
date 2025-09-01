package com.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO{
	private ProductDTO product;
	private String message;
	private String status;
}