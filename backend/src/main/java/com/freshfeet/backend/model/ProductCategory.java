package com.freshfeet.backend.model;


import jakarta.persistence.*;
import org.springframework.data.util.Lazy;

import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Long id;

    private String category;

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="fk_parent_cat")
    private ProductCategory parentCategory;

    @OneToMany(mappedBy = ProductCategory_.PARENT_CATEGORY)
    private Set<ProductCategory> subCategory;

    @OneToMany(mappedBy = PromotionCategory_.PRODUCT_CATEGORY)//Parent entity
    private Set<PromotionCategory> promotionCategories;


    public Long getId(){
        return this.id;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public ProductCategory getParentCategory(){
        return this.parentCategory;
    }

    public void setParentCategory(ProductCategory parentCategory){
        this.parentCategory = parentCategory;
    }


    //BiDirectional Mapping for parent and sub-cat
    public void addSubCategory(ProductCategory subCategory){
        this.subCategory.add(subCategory);
        subCategory.setParentCategory(this);
    }

    public Set<ProductCategory>getSubCategory(){
        return subCategory;
    }


    //Bi-Directional Rls for parent and child(Product Category and Promotion Category)
    public void addPromotionCategory(PromotionCategory promotionCategory){
        this.promotionCategories.add(promotionCategory);
        promotionCategory.setProductCategory(this);
    }

    public Set<PromotionCategory> getPromotionCategories(){
        return this.promotionCategories;
    }

}
