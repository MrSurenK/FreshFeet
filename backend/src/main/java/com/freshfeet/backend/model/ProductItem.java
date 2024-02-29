package com.freshfeet.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
public class ProductItem {

    // Fields
    @Id
    private String Sku; // SKU is the natural id for product item table

    private Integer qtyInStock;

    @Column(precision=8, scale=2 )
    private BigDecimal price;

    private String productImage;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_product_id") //Foreign Key name (Owning side)
    private Product product;

    @OneToMany(mappedBy = ProductConfiguration_.PRODUCT_ITEM)
    private Set<ProductConfiguration> productConfigurations;

    @OneToMany(mappedBy = ShoppingCartItem_.PRODUCT_ITEM)
    private Set<ShoppingCartItem> shoppingCartItem;

    @OneToMany(mappedBy = OrderLine_.PRODUCT_ITEM)
    private Set<OrderLine> orderLines;


    //Setters and Getters
    public String getSku(){
        return this.Sku;
    }

    public void setSku(String Sku){
        this.Sku = Sku;
    }

    public Integer getQtyInStock(){
        return this.qtyInStock;
    }

    public void setQtyInStock(Integer qtyInStock){
        this.qtyInStock = qtyInStock;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public String getProductImage(){return this.productImage;}

    public void setProductImage(String productImage){this.productImage = productImage;}

    public Product getProduct(){
        return this.product;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public Set<ProductConfiguration> getProductConfigurations(){
        return this.productConfigurations;
    }

    public void setProductConfigurations(ProductConfiguration productConfiguration){
        this.productConfigurations.add(productConfiguration);
        productConfiguration.setProductItem(this);
    }

    public Set<ShoppingCartItem> getShoppingCartItem(){
        return this.shoppingCartItem;
    }

    public void setShoppingCartItem(ShoppingCartItem shoppingCartItem){
        this.shoppingCartItem.add(shoppingCartItem);
        shoppingCartItem.setProductItem(this);
    }

    public Set<OrderLine> getOrderLines(){
        return this.orderLines;
    }

    public void setOrderLines(OrderLine orderLine){
        this.orderLines.add(orderLine);
        orderLine.setProductItem(this);
    }


}
