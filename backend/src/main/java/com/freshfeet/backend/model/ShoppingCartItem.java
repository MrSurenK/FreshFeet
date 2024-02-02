package com.freshfeet.backend.model;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigInteger quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_item_id")
    private ProductItem productItem;


    //Setters and Getters
    public Long getId(){
        return this.id;
    }

    public BigInteger getQuantity(){
        return this.quantity;
    }

    public void setQuantity(BigInteger quantity){
        this.quantity = quantity;
     }

     public ShoppingCart getShoppingCart(){
        return this.shoppingCart;
     }

     public void setShoppingCart(ShoppingCart shoppingCart){
        this.shoppingCart = shoppingCart;
     }

     public ProductItem getProductItem(){
        return this.productItem;
     }

     public void setProductItem(ProductItem productItem){
        this.productItem = productItem;
     }

}
