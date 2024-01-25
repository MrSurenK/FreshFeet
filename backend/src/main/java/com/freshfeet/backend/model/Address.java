package com.freshfeet.backend.model;

import jakarta.persistence.*;
import org.springframework.data.util.Lazy;


import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long addressId;

    @OneToMany(mappedBy = UserAddress_.ADDRESS)
    private Set<UserAddress> userAddress;

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="countryId", foreignKey = @ForeignKey(name="FK_Address_country_id"))
    private Country country;

    private int unitNumber;

    private int blockNumber;

    private String streetName;

    private String city;

    private int postalCode;

    private int country_id;

}

