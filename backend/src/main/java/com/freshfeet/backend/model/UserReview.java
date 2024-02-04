package com.freshfeet.backend.model;

import jakarta.persistence.*;

@Entity
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer rating;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String comment;


    //Setters and Getters
    public Long getId(){
        return this.id;
    }

    public Integer getRating(){
        return this.rating;
    }

    public void setRating(Integer rating){
        this.rating = rating;
    }

    public String getComment(){
        return this.comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }



}
