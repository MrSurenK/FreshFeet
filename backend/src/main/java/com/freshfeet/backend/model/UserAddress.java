//package com.freshfeet.backend.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//
//
//import java.util.Set;
//
//import static jakarta.persistence.FetchType.LAZY;
//
//@Entity
//public class UserAddress {
//
//    @ManyToOne(fetch=LAZY)
//    @JoinColumn(name="user_id") //foreign key in UserAddressTable
//    private Set<UserAccount> userAccount;
//
//
//
//
//    private boolean isDefault;
//
//    public boolean getIsDefault()
//    {
//        return this.isDefault;
//    }
//
//    public void setIsDefault(boolean isDefault){
//        this.isDefault= isDefault;
//    }
//}


