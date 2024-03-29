package com.freshfeet.backend.model;

import com.freshfeet.backend.util.CustomUserId;
import jakarta.persistence.*;
import org.springframework.aot.hint.SerializationHints;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
public class UserAccount {

    @Id
    @CustomUserId(name ="userid_seq", prefix="user_") // userid sequence for custom unique id generation
    private String userId;

    @OneToMany(mappedBy=UserAddress_.USER_ACCOUNT) // One user can store many addresses
    List<UserAddress> userAddresses;

    @OneToMany(mappedBy = UserPaymentMethod_.USER_ID)
    private Set<UserPaymentMethod> userPaymentMethods;

    @OneToMany(mappedBy = ShopOrder_.USER_ID)
    private Set<ShopOrder> orders;

    @OneToMany(mappedBy = ShoppingCart_.USER_ID)
    private Set<ShoppingCart> carts;

    @OneToMany(mappedBy = UserReview_.USER_ACCOUNT)
    private Set<UserReview> userReviews;

    private String name;

//    @Basic(optional = false)
    private String email;

//    @Basic(optional = false)
//    ToDo: Before creating APIs, ensure Spring Security is configured and password is hashed with Bcrypt
    private String password; // Password has no getter as a precautionary security measure

    @Lob // Wrapper for blob datatype to store images
    @Column(name="display_pic", columnDefinition = "LONGBLOB")
    private byte[] displayPic;

    private String gender;

    private LocalDate dateOfBirth;

    private String contactNo;

     private String role; // Assign a role based on email domain

    @Column(nullable=false)
    private boolean is_active = true;

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

    public List<UserAddress> getUserAddresses(){
        return userAddresses;
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

    // Bi-Directional Setters and Getters
    public Set<UserPaymentMethod> getUserPaymentMethods(){
        return this.userPaymentMethods;
    }
    public void setUserPaymentMethods(UserPaymentMethod userPaymentMethod){
        this.userPaymentMethods.add(userPaymentMethod);
        userPaymentMethod.setUserId(this);
    }

    public Set<ShopOrder>getOrders(){
        return this.orders;
    }

    public void setOrders(ShopOrder order){
        this.orders.add(order);
        order.setUserId(this);
    }


    public Set<ShoppingCart>getCarts(){
        return this.carts;
    }

    public void setCarts(ShoppingCart cart){
        this.carts.add(cart);
        cart.setUserId(this);
    }

    public Set<UserReview> getUserReviews(){
        return this.userReviews;
    }

    public void setUserReviews(UserReview userReview){
        this.userReviews.add(userReview);
        userReview.setUserAccount(this);
    }

}
