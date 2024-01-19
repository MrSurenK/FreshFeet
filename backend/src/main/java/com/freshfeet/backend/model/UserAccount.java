package com.freshfeet.backend.model;

import com.freshfeet.backend.util.CustomUserId;
import jakarta.persistence.*;


@Entity
public class UserAccount {

    @Id
    @CustomUserId(name ="userid_seq") // userid sequence for custom unique id generation
    private String id;

    private String name;
    @Lob
    @Column(name="display_pic", columnDefinition = "LONGBLOB")
    private byte[] displayPic;


    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public byte[] getDisplayPic(){
        return this.displayPic;
    }

    public void setDisplayPic(byte[] displayPic){
        this.displayPic = displayPic;
    }

}
