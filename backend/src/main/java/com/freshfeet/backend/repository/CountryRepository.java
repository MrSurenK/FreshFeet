package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
