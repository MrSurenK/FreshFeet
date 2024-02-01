package com.freshfeet.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ShopOrder {

    //Custom order id (receipt)
    @Id
    private String orderId;




}
