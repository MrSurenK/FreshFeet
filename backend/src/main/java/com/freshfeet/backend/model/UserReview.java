package com.freshfeet.backend.model;

import jakarta.persistence.*;

@Entity
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer rating;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String comment;

    @ManyToOne
    @JoinColumn(name="fk_ordered_product_id")
    private OrderLine orderLine;


    @ManyToOne
    @JoinColumn(name="fk_user_id")
    private UserAccount userAccount;


    //Setters and Getters
    public Long getId(){
        return this.id;
    }

    public Integer getRating(){
        return this.rating;
    }

    public void setRating(Integer rating){
        this.rating = rating;
    }

    public String getComment(){
        return this.comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public OrderLine getOrderLine(){
        return this.orderLine;
    }

    public void setOrderLine(OrderLine orderLine){
        this.orderLine = orderLine;
    }

    public UserAccount getUserAccount(){
        return this.userAccount;
    }

    public void setUserAccount(UserAccount userAccount){
        this.userAccount= userAccount;
    }

}
