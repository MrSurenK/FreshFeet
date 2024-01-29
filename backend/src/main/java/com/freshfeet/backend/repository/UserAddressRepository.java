package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

}
