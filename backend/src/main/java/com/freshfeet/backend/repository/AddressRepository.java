package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
