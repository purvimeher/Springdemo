package com.example.springdemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public  String brand_category;
    public  String brand;
    public  String size_ml;
    public double maximum_retail_price_per_bottle;

    public Product() {
    }

    public Product(String BRAND_CATEGORY, String productName, String volume, double Maximum_Retail_Price_Per_Bottle) {
        this.brand_category = BRAND_CATEGORY;
        this.brand = productName;
        this.size_ml = volume;
        this.maximum_retail_price_per_bottle = Maximum_Retail_Price_Per_Bottle;
    }

    public String getBrand_category() {
        return brand_category;
    }

    public String getBrand() {
        return brand;
    }

    public String getSize_ml() {
        return size_ml;
    }

    public double getMaximum_retail_price_per_bottle() {
        return maximum_retail_price_per_bottle;
    }
}
