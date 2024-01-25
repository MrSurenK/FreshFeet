package com.freshfeet.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer countryId;

    @OneToMany(mappedBy = Address_.COUNTRY)
    private Set<Address> Address;

    private String countryName;

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }
}
