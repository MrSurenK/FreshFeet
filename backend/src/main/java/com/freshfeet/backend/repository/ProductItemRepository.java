package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {
}
