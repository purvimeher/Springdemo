package com.example.springdemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public  String BRAND_CATEGORY;
    public  String BRAND;
    public  String Size_ML;
    public double MAXIMUM_RETAIL_PRICE_PER_BOTTLE;

    public Product() {
    }

    public Product(String BRAND_CATEGORY, String productName, String volume, double Maximum_Retail_Price_Per_Bottle) {
        this.BRAND_CATEGORY = BRAND_CATEGORY;
        this.BRAND = productName;
        this.Size_ML = volume;
        this.MAXIMUM_RETAIL_PRICE_PER_BOTTLE = Maximum_Retail_Price_Per_Bottle;
    }

    public String getBRAND_CATEGORY() {
        return BRAND_CATEGORY;
    }

    public String getBRAND() {
        return BRAND;
    }

    public String getSize_ML() {
        return Size_ML;
    }

    public double getMAXIMUM_RETAIL_PRICE_PER_BOTTLE() {
        return MAXIMUM_RETAIL_PRICE_PER_BOTTLE;
    }
}
