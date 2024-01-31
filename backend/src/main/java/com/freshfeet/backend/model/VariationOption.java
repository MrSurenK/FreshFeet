package com.freshfeet.backend.model;

import jakarta.persistence.*;

import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class VariationOption {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String value; //Value can be a shirt size or shoe size or colour

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="fk_variation_id")
    private Variation variation;

    //Getters and Setters
    public Long getId(){
        return this.id;
    }

    public String getValue(){
        return this.value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public Variation getVariation(){
        return this.variation;
    }
    public void setVariation(Variation variation){
        this.variation = variation;
    }


}
