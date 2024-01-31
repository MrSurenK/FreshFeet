package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPaymentMethodRepository extends JpaRepository<UserPaymentMethod,Long> {
}
