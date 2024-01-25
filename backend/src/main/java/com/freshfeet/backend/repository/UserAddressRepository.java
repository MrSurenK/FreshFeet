package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.UserAddress;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressRepository extends CrudRepository<UserAddress, Long> {

}
