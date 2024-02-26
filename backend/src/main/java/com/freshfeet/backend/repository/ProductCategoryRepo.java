package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
}
