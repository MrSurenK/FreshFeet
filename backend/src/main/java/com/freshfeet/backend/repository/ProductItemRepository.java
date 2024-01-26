package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.ProductItem;
import org.springframework.data.repository.CrudRepository;

public interface ProductItemRepository extends CrudRepository<ProductItem, Integer> {
}
