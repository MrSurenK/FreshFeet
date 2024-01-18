package com.freshfeet.backend.model;

import jakarta.persistence.*;


@Entity
public class UserAccount {

    @Id
    @CustomUserId(name ="userid_seq") // userid sequence for custom unique id generation
    private String id;

    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}
