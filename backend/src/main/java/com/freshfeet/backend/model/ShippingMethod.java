package com.freshfeet.backend.model;


import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

import java.math.BigDecimal;
import java.util.Set;

@Entity
public class ShippingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    //Price to store up-to-date market rate for shipping
    @Column(precision = 4, scale = 2)
    private BigDecimal price;


    @OneToMany(mappedBy = ShopOrder_.SHIPPING_METHOD)
    private Set<ShopOrder> shopOrders;


    //Getters and Setters
    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Bi-Directional Setters and Getters
    public Set<ShopOrder> getShopOrders(){
        return this.shopOrders;
    }

    public void setShopOrders(ShopOrder shopOrder){
        this.shopOrders.add(shopOrder);
        shopOrder.setShippingMethod(this);
    }



}
