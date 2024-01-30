package com.freshfeet.backend.model;

import jakarta.persistence.*;


import static jakarta.persistence.FetchType.LAZY;


@Entity
public class PromotionCategory {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch= LAZY)
    @JoinColumn(name="fk_promotion_id")
    private Promotion promotionId;

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="fk_category_id")//Child entity
    private ProductCategory productCategory;



    //Setters and Getters
    public Long getId(){
        return this.id;
    }

    public Promotion getPromotionId(){
        return this.promotionId;
    }

    public void setPromotionId(Promotion promotionId){
        this.promotionId=promotionId;
    }

    public ProductCategory getProductCategory(){
        return this.productCategory;
    }

    public void setProductCategory(ProductCategory productCategory){this.productCategory=productCategory;}

}
