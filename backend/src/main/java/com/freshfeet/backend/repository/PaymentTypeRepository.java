package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Byte> {
}
