package com.freshfeet.backend.model;

import jakarta.persistence.*;


import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;

@Entity
public class UserAddress {

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="user_id", foreignKey = @ForeignKey(name="user_id")) //foreign key in UserAddressTable
    private UserAccount userAccount;

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="address_id", foreignKey = @ForeignKey(name="address_id"))
    private Address address;

    private boolean isDefault;

    public boolean getIsDefault()
    {
        return this.isDefault;
    }

    public void setIsDefault(boolean isDefault){
        this.isDefault= isDefault;
    }
}


