package com.freshfeet.backend.model;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Var;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class ProductConfiguration {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="fk_variation_option_id")
    private VariationOption variationOption;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="fk_product_item_id")
    private ProductItem productItem;



    //Setters and Getters
    public Long getId(){
        return this.id;
    }

    public VariationOption getVariationOption(){
        return this.variationOption;
    }

    public void setVariationOption(VariationOption variationOption){
        this.variationOption = variationOption;
    }

    public ProductItem getProductItem(){
        return this.productItem;
    }
    public void setProductItem(ProductItem productItem){
        this.productItem = productItem;
    }

}
