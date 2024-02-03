package com.freshfeet.backend.model;

import com.freshfeet.backend.util.CustomOrderId;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class ShopOrder {

    //Custom order id (receipt)
    @Id
    @CustomOrderId(name="order_no", prefix = "order_")
    private String orderId;

    private LocalDate orderDate;

    @Column(precision = 6, scale = 2)
    private BigDecimal shippingPrice; // Shipping price is itemized to preserve accuracy of price data

    @Column(precision = 8, scale= 2)
    private BigDecimal orderTotal;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_user_id")
    private UserAccount userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_payment_method_id")
    private UserPaymentMethod userPaymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_address")
    private Address address;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_shipping_method_id")
    private ShippingMethod shippingMethod;


    //Setters and Getters
    public String getOrderId(){
        return this.orderId;
    }

    public LocalDate getOrderDate(){return this.orderDate;}

    public void setOrderDate(LocalDate orderDate){
        this.orderDate = orderDate;
    }

    public BigDecimal getShippingPrice(){
        return this.shippingPrice;
    }

    public void setShippingPrice(BigDecimal shippingPrice){
        this.shippingPrice = shippingPrice;
    }
    public BigDecimal getOrderTotal(){
        return this.orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal){
        this.orderTotal = orderTotal;
    }

    public OrderStatus getOrderStatus(){
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }

    // Bi-Directional setters and getters
    public UserAccount getUserId(){
        return this.userId;
    }

    public void setUserId(UserAccount userId){
        this.userId = userId;
    }

    public ShoppingCart getShoppingCart(){
        return this.shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart){
        this.shoppingCart = shoppingCart;
    }

    public UserPaymentMethod getUserPaymentMethod(){
        return this.userPaymentMethod;
    }

    public void setUserPaymentMethod(UserPaymentMethod userPaymentMethod){
        this.userPaymentMethod = userPaymentMethod;
    }

    public Address getAddress(){
        return this.address;
    }

    public void setAddress(Address address){
        this.address = address;
    }


    public ShippingMethod getShippingMethod(){
        return this.shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod){
        this.shippingMethod = shippingMethod;
    }












}
