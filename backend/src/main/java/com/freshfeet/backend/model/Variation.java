package com.freshfeet.backend.model;

import jakarta.persistence.*;

import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Variation {
    @Id
    @GeneratedValue(strategy =IDENTITY)
    private Long id;


    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="fk_category_id")
    private ProductCategory category;

    @OneToMany(mappedBy = VariationOption_.VARIATION)
    private Set<VariationOption> variationOptions;


    //Getters and Setters
    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ProductCategory getCategory(){
        return this.category;
    }

    public void setCategory(ProductCategory category){
        this.category = category;
    }

    public Set<VariationOption> getVariationOptions(){
        return this.variationOptions;
    }

    public void setVariationOptions(VariationOption variationOption){
        this.variationOptions.add(variationOption);
        variationOption.setVariation(this);
    }

}
