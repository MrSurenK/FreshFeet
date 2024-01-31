package com.freshfeet.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Entity
public class UserPaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String provider;

    private Long cardNumber;

    private LocalDate expiryDate;

    private boolean isDefault;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="fk_user_id")
    private String userId;


    //Setters and Getters
    public Long getId(){
        return this.id;
    }

    public String getProvider(){
        return this.provider;
    }

    public void setProvider(String provider){
        this.provider=provider;
    }

    public Long getCardNumber(){
        return this.cardNumber;
    }

    public void setCardNumber(Long cardNumber){
        this.cardNumber=cardNumber;
    }

    public LocalDate getExpiryDate(){
        return this.expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate){
        this.expiryDate = expiryDate;
    }

    public boolean getDefault(){
        return this.isDefault;
    }

    public void setDefault(boolean isDefault){
        this.isDefault = isDefault;
    }

    //Bi-Directional Setters and Getters



}
