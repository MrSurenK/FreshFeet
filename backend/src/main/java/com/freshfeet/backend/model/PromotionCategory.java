package com.freshfeet.backend.model;

import jakarta.persistence.*;
import org.springframework.data.util.Lazy;

import java.util.Set;

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
