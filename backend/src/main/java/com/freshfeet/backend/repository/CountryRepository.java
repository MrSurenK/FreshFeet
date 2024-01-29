package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, Integer> {
}
