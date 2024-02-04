package com.freshfeet.backend.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.hibernate.grammars.hql.HqlParser;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LikeCompositeKeys implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;


    @ManyToOne(fetch = FetchType.LAZY)
    private ProductItem productItem;


    //Args constructor
    public LikeCompositeKeys(UserAccount userAccount, ProductItem productItem){
        this.userAccount = userAccount;
        this.productItem = productItem;
    }

    //No args constructor
    private LikeCompositeKeys(){}

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        // Since method has determined that o is not null and is of the same class as the current instance
        // We can safely cast o to LikeCompositeKeys type (Type Casting)
        // We need to cast it to compare the specific fields of LikeCompositeKeys
        LikeCompositeKeys keys = (LikeCompositeKeys)o;

        //current instance is compared with passed instance ('keys')
        return Objects.equals(userAccount, keys.userAccount) &&
                Objects.equals(productItem, keys.productItem);
    }

    @Override
    public int hashCode(){
        return Objects.hash(userAccount, productItem);
    }

}
