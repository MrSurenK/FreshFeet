package com.freshfeet.backend.model;

import com.freshfeet.backend.util.CustomOrderId;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ShopOrder {

    //Custom order id (receipt)
    @Id
    @CustomOrderId(name="order_no", prefix = "order_")
    private String orderId;

    private LocalDate orderDate;

    @Column(precision = 8, scale= 2)
    private BigDecimal orderTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_user_id")
    private UserAccount userId;




    //Setters and Getters
    public String getOrderId(){
        return this.orderId;
    }

    public LocalDate getOrderDate(){return this.orderDate;}

    public void setOrderDate(LocalDate orderDate){
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderTotal(){
        return this.orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal){
        this.orderTotal = orderTotal;
    }

    // Bi-Directional setters and getters
    public UserAccount getUserId(){
        return this.userId;
    }

    public void setUserId(UserAccount userId){
        this.userId = userId;
    }


}
