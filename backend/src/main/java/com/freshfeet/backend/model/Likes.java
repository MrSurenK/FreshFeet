package com.freshfeet.backend.model;

import jakarta.persistence.*;

@Entity
public class Likes {

    @EmbeddedId
    private LikeCompositeKeys keys;

    //Setters and Getters
    public LikeCompositeKeys getKeys(){
        return this.keys;
    }

    public void setKeys(LikeCompositeKeys keys){
        this.keys = keys;
    }

}
