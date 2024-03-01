package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.Product;
import com.freshfeet.backend.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByName(String name);
}
