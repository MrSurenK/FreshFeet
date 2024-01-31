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

    @OneToMany(mappedBy = ProductConfiguration_.VARIATION_OPTION)
    private Set<ProductConfiguration> productConfigurations;

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

    public Set<ProductConfiguration> getProductConfigurations(){
        return this.productConfigurations;
    }

    public void setProductConfigurations(ProductConfiguration productConfiguration){
        this.productConfigurations.add(productConfiguration);
        productConfiguration.setVariationOption(this);
    }

}
