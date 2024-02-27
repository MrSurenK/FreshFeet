package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProductItemRepository extends JpaRepository<ProductItem, String> {
    Optional<ProductItem> findBySku(ProductItem sku);
}
