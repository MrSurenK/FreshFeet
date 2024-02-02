package com.freshfeet.backend.model;

import jakarta.persistence.*;

public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionId;
    @Enumerated(EnumType.STRING)
    private CartStatus status;

    // Setters and Getters
    public Long getId(){
        return this.id;
    }

    public String getSessionId(){
        return this.sessionId;
    }

    public void setSessionId(String sessionId){
        this.sessionId = sessionId;
    }

    public CartStatus getStatus(){
        return this.status;
    }

    public void setStatus(CartStatus status){
        this.status = status;
    }

}
