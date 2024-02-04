package com.freshfeet.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @Column(precision = 8, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="fk_shop_order_id")
    private ShopOrder shopOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_product_item_id")
    private ProductItem productItem;

    @OneToMany(mappedBy = UserReview_.ORDER_LINE)
    private Set<UserReview> userReviews;


    //Setters and Getters
    public Long getId(){
        return this.id;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public ShopOrder getShopOrder(){
        return this.shopOrder;
    }

    public void setShopOrder(ShopOrder shopOrder){
        this.shopOrder = shopOrder;
    }

    public ProductItem getProductItem(){
        return this.productItem;
    }

    public void setProductItem(ProductItem productItem){
        this.productItem = productItem;
    }

    public Set<UserReview> getUserReviews(){
        return this.userReviews;
    }

    public void setUserReviews(UserReview userReview){
        this.userReviews.add(userReview);
        userReview.setOrderLine(this);
    }

}
