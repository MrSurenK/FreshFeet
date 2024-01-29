package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

}
