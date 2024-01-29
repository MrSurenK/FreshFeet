package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}
