package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.LikeCompositeKeys;
import com.freshfeet.backend.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes,LikeCompositeKeys> {
}
