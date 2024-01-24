package com.freshfeet.backend.model;

import jakarta.persistence.*;


import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class UserAddress {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="user_id", foreignKey = @ForeignKey(name="user_id")) //foreign key in UserAddressTable
    private UserAccount userAccount;

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="address_id", foreignKey = @ForeignKey(name="address_id"))
    private Address address;

    private boolean isDefault;

    public UserAccount getUserAccount(){
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount){
        this.userAccount = userAccount;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public boolean getIsDefault()
    {
        return this.isDefault;
    }

    public void setIsDefault(boolean isDefault){
        this.isDefault= isDefault;
    }
}


