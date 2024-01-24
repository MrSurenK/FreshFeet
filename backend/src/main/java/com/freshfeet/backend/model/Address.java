package com.freshfeet.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long addressId;

    @OneToMany(mappedBy = UserAddress_.ADDRESS)
    private Set<UserAddress> userAddress;

    private int unitNumber;

    private int blockNumber;

    private String streetName;

    private String city;

    private int postalCode;

    private int country_id;

}

