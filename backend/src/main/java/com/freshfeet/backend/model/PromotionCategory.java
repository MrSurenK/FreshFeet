package com.freshfeet.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PromotionCategory {

    @Id
    @GeneratedValue
    private Long id;


    //Setters and Getters
    public Long getId(){
        return this.id;
    }



}
