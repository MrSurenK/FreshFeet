package com.freshfeet.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class VariationOption {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String value; //Value can be a shirt size or shoe size or colour

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





}
