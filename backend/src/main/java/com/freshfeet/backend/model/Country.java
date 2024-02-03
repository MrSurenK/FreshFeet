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
    private Set<Address> address;

    private String countryName;

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public Set<Address> getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address.add(address);
        address.setCountry(this);
    }
}
