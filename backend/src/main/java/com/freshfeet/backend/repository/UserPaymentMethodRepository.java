package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserPaymentMethodRepository extends JpaRepository<UserPaymentMethod, UUID> {
}
