package com.freshfeet.backend.model;

import jakarta.persistence.*;



import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class UserAddress {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch=LAZY)
//    @JoinColumn(name="userId", foreignKey = @ForeignKey(name="test")) //foreignkey contraint does not change the name on the table itself.
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


