package com.freshfeet.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id; //Tinyint in MySQL  (max value of 127 assigned)


    private String value; //GrabPay, CreditCard, Account Number etc...


//    Getters and Setters
    public Byte getId(){
        return this.id;
    }

    public String getValue(){
        return this.value;
    }

    public void setValue(String value){
        this.value = value;
    }

}
