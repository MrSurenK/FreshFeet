package com.freshfeet.backend.model;

import com.freshfeet.backend.util.CustomOrderId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class ShopOrder {

    //Custom order id (receipt)
    @Id
    @CustomOrderId(name="order_no", prefix = "order_")
    private String orderId;

    private LocalDate orderDate;














    //Setters and Getters
    public String getOrderId(){
        return this.orderId;
    }







}
