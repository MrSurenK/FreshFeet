package com.freshfeet.backend.model;

import jakarta.persistence.*;


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
//    @JoinColumn(name="countryId", foreignKey = @ForeignKey(name="FK_Address_country_id"))
    @JoinColumn(name="fk_country_id")
    private Country country;

    @OneToMany(mappedBy = ShopOrder_.ADDRESS)
    private Set<ShopOrder> shopOrders;

    private Integer unitNumber;

    private Integer blockNumber;

    private String streetName;

    private String city;

    private Long postalCode;

    //Setters and Getters
    public Long getAddressId(){
        return this.addressId;
    }

    public Integer getUnitNumber(){
        return  this.unitNumber;
    }

    public void setUnitNumber(Integer unitNumber){
        this.unitNumber = unitNumber;
    }

    public Integer getBlockNumber(){
        return this.blockNumber;
    }

    public void setBlockNumber(Integer blockNumber){
        this.blockNumber = blockNumber;
    }

    public String getStreetName(){
        return this.streetName;
    }

    public void setStreetName(String streetName){
        this.streetName = streetName;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public Long getPostalCode(){
        return this.postalCode;
    }

    public void setPostalCode(Long postalCode){
        this.postalCode = postalCode;
    }


    //Bidirectional setters and getters
    public Set<UserAddress> getUserAddress(){
        return this.userAddress;
    }

    public void setUserAddress(UserAddress userAddress){
        this.userAddress.add(userAddress);
        userAddress.setAddress(this);
    }

    public Country getCountry(){
        return this.country;
    }

    public void setCountry(Country country){
        this.country = country;
    }

    public Set<ShopOrder> getShopOrders(){
        return this.shopOrders;
    }

    public void setShopOrders(ShopOrder shopOrder){
        this.shopOrders.add(shopOrder);
        shopOrder.setAddress(this);
    }

}

