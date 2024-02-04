package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReviewRepository extends JpaRepository<UserReview,Long> {
}
