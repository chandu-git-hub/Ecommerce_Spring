package com.example.ecommercespring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Category extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy = "category",fetch= FetchType.EAGER)
    private List<Product> products;

}
