package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
