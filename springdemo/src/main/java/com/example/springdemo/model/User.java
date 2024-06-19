package com.example.springdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "VendorInfoDetails")
public class User {

    @Id
    public int vendorId;
    public String name;
    public String location;
    public LocalDateTime createdOn;

    public String getName() {
        return name;
    }

    public int getVendorId() {
        return vendorId;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
