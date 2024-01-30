package com.freshfeet.backend.model;


import jakarta.persistence.*;
import org.aspectj.weaver.ast.Var;
import org.springframework.data.util.Lazy;

import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String categoryName;

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="fk_parent_cat")
    private ProductCategory parentCategory;

    @OneToMany(mappedBy = ProductCategory_.PARENT_CATEGORY)
    private Set<ProductCategory> subCategory;

    @OneToMany(mappedBy = PromotionCategory_.PRODUCT_CATEGORY)//Parent entity
    private Set<PromotionCategory> promotionCategories;

    @OneToMany(mappedBy = Variation_.CATEGORY)
    private Set<Variation> variations;


    public Long getId(){
        return this.id;
    }

    public String getCategoryName(){
        return this.categoryName;
    }

    public void setCategory(String categoryName){
        this.categoryName = categoryName;
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

    public Set<Variation> getVariations(){
        return this.variations;
    }

    //Bi-Directional Rls with variation
    public void addVariation(Variation variation){
        this.variations.add(variation);
        variation.setCategory(this);
    }



}

