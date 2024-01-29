package com.freshfeet.backend.model;

import jakarta.persistence.*;


import static jakarta.persistence.FetchType.LAZY;


@Entity
public class PromotionCategory {

    @Id
    @GeneratedValue
    private Long id;

//    @ManyToOne
//    @join
//    private Set<ProductCategory> productCat;


    @ManyToOne(fetch= LAZY)
    @JoinColumn(name="fk_promotion_id")
    private Promotion promotionId;

//    @ManyToOne(fetch=LAZY)
//    @JoinColumn(name="fk_product_id")
//    private Product product;


    //Setters and Getters
    public Long id(){
        return this.id;
    }

    public Promotion getPromotionId(){
        return this.promotionId;
    }

    public void setPromotionId(Promotion promotionId){
        this.promotionId=promotionId;
    }

}
