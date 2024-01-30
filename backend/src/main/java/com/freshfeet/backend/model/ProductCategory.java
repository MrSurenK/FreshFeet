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

    public Set<ProductCategory>getSubCategory(){
        return subCategory;
    }

    //BiDirectional Mapping for parent and sub-cat


}
