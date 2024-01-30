package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.Variation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariationRepository extends JpaRepository<Variation,Long> {
}
