package com.freshfeet.backend.model;

import jakarta.persistence.*;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionId;
    @Enumerated(EnumType.STRING)
    private CartStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_user_id")
    private UserAccount userId;

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

    // Bi-Directional setters and getters
    public UserAccount getUserId(){
        return this.userId;
    }

    public void setUserId(UserAccount userId){
        this.userId = userId;
    }
}
