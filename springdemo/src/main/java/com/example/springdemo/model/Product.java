package com.example.springdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column
    public int Id;
    public final String productCategory;
    public final String  productName;
    public final String Size_ML;
    public double Maximum_Retail_Price_Per_Bottle;

    public Product(String productCategory, String productName, String volume, double Maximum_Retail_Price_Per_Bottle) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.Size_ML = volume;
        this.Maximum_Retail_Price_Per_Bottle = Maximum_Retail_Price_Per_Bottle;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public String getSize_ML() {
        return Size_ML;
    }

    public double getMaximum_Retail_Price_Per_Bottle() {
        return Maximum_Retail_Price_Per_Bottle;
    }
}
