package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.ProductConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductConfigurationRepository extends JpaRepository<ProductConfiguration,Long> {

}
