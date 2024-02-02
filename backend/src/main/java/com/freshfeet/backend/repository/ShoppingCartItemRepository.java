package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem,Long> {
}
