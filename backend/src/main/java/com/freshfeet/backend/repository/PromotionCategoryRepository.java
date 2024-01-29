package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.PromotionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionCategoryRepository extends JpaRepository<PromotionCategory, Long> {
}
