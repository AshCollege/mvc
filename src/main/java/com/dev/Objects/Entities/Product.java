package com.dev.Objects.Entities;

import com.dev.Objects.General.BaseEntity;

public class Product extends BaseEntity {
    private String name;
    private String price;
    private String productDescription;
    private Seller seller;


    public Product() {
    }

    public Product(String name, String price, String productDescription) {
        this.name = name;
        this.price = price;
        this.productDescription = productDescription;
    }


    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String checkName() {
        return this.name == null ? "UNKNOWN" : this.name;

    }

    public String checkPrice() {
        return this.price == null ? "UNKNOWN" : this.price;
    }

    public String chechDescription() {
        return this.productDescription == null ? "UNKNOWN" : this.productDescription;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
