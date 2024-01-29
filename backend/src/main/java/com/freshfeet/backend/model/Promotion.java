package com.freshfeet.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@Entity
public class Promotion {

    @Id
    @GeneratedValue
    private Long id;

    private String promoTitle;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;


    private BigDecimal discount_rate;

    private LocalDate startDate;

    private LocalDate endDate;

    //String will be directory location
    private String bannerImage;

    @OneToMany(mappedBy = PromotionCategory_.PROMOTION_ID)
    private Set<PromotionCategory> promoCat;


    // Setter and Getters
    public Long getId(){
        return this.id;
    }

    public String getPromoTitle(){
        return this.promoTitle;
    }

    public void setPromoTitle(String title){
        this.promoTitle = title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public BigDecimal getDiscount_rate(){
        return this.discount_rate;
    }

    public void setDiscount_rate(BigDecimal discount_rate){
        this.discount_rate = discount_rate;
    }

    public LocalDate getStartDate(){
        return this.startDate;
    }

    public void setStartDate(LocalDate start_date){
        this.startDate = start_date;
    }

    public LocalDate getEndDate(){
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }

    public String getBannerImage(){
        return this.bannerImage;
    }


    // Banner Image parameter must be the valid file path
    public void setBannerImage(String bannerImage){
        this.bannerImage = bannerImage;
    }

    public Set<PromotionCategory>getPromoCat(){
        return promoCat;
    }

}
