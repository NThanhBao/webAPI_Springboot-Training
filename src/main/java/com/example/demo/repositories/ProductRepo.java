package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.entity.Products;

/**
 * Repository interface for Product entity.
 */
@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {
}