package com.freshfeet.backend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id; //Tinyint in MySQL  (max value of 127 assigned)


    private String value; //GrabPay, CreditCard, Account Number etc...

    @OneToMany(mappedBy = UserPaymentMethod_.PAYMENT_TYPE)
    private Set<UserPaymentMethod> paymentMethods;


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

    public Set<UserPaymentMethod> getPaymentMethods(){
        return this.paymentMethods;
    }

//    Bi-Directional Setters

    public void setPaymentMethods(UserPaymentMethod paymentMethod){
        this.paymentMethods.add(paymentMethod);
        paymentMethod.setPaymentType(this);
    }

}
