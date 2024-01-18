package com.freshfeet.backend.model;

import com.freshfeet.backend.util.CustomUserId;
import jakarta.persistence.*;


@Entity
public class UserAccount {

    @Id
    @CustomUserId(name ="userid_seq") // userid sequence for custom unique id generation
    private String id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


}
