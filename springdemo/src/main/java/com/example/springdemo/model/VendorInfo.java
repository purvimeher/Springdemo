package com.example.springdemo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vendor_info")
public class VendorInfo {

    @Id
//    @Column(name="vendorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int vendorId;
    public String name;
    public String location;
    public LocalDateTime createdOn;

    public VendorInfo() {
    }

    public VendorInfo(int vendorId, String name, String location) {
        this.vendorId = vendorId;
        this.name = name;
        this.location = location;
    }

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
