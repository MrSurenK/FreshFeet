package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
