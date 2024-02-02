package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopOrderRepository extends JpaRepository<ShopOrder, String> {
}
