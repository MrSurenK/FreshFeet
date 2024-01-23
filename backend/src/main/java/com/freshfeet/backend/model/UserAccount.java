package com.freshfeet.backend.model;

import com.freshfeet.backend.util.CustomUserId;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Entity
public class UserAccount {

    @Id
    @CustomUserId(name ="userid_seq") // userid sequence for custom unique id generation
    private String id;

    @OneToMany(mappedBy=UserAddress_.USERACCOUNT)
    List<UserAddress> userAddress;

    private String name;

    @Basic(optional = false)
    private String email;

    @Basic(optional = false)
    private String password;   // Password has no getter as a precautionary security measure

    @Lob // Wrapper for blob datatype to store images
    @Column(name="display_pic", columnDefinition = "LONGBLOB")
    private byte[] displayPic;

    private String gender;

    private LocalDate dateOfBirth;

    private String contactNo;

     private String role; // ToDo: remember to assign a role based on email domain

    private boolean is_active; //ToDo: Give a default true to all new accounts

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){ return this.email;}

    public void setEmail(String email){this.email = email;}


    //ToDo: Hash password using Bcrypt before saving into Database and un-hash password when retrieving it.
    public void setPassword(String password){
        this.password = password;
    }

    public byte[] getDisplayPic(){
        return this.displayPic;
    }

    public void setDisplayPic(byte[] displayPic){
        this.displayPic = displayPic;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    // ToDo: Format the dob to dd/mm/yyyy before persisting into database in a util class: This will be the standard all through the application
    public void setDateOfBirth(LocalDate dob){
        this.dateOfBirth = dob;
    }

    public String getContactNo(){
        return this.contactNo;
    }

    //ToDo: Format contact No with country code before saving into database in service class.
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }

    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public boolean is_active(){
        return this.is_active;
    }

    public void is_active(boolean isActive){
        this.is_active = isActive;
    }


}
