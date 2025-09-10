package com.example.ecommercespring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column(nullable = false,updatable = false)
    private Instant created_at;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updated_at;

    @PrePersist
    public void onCreate(){
        Instant now=Instant.now();
        created_at=now;
        updated_at=now;
    }

    @PreUpdate
    public void onUpdate(){
        Instant now=Instant.now();
        updated_at=now;
    }

}
