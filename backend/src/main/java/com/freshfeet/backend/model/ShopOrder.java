package com.freshfeet.backend.model;

import com.freshfeet.backend.util.CustomOrderId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ShopOrder {

    //Custom order id (receipt)
    @Id
    @CustomOrderId(name="order_no", prefix = "order_")
    private String orderId;










    //Setters and Getters
    public String getOrderId(){
        return this.orderId;
    }







}
