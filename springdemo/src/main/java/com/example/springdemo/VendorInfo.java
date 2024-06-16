package com.example.springdemo;

import java.time.LocalDateTime;

public class VendorInfo {

    public String vendorID;
    public String name;
    public String location;
    private LocalDateTime createdOn;

    public VendorInfo() {
    }

    public VendorInfo(String vendorID, String name, String location) {
        this.vendorID = vendorID;
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getVendorID() {
        return vendorID;
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
