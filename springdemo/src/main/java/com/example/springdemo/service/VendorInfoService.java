package com.example.springdemo.service;

import com.example.springdemo.model.VendorInfo;

import java.util.List;

public interface VendorInfoService {

    public String createVendorInfo(VendorInfo vendorInfo);
    public String updateVendorInfo(VendorInfo vendorInfo);
    public String deleteVendorInfo(String vendorId);
    public VendorInfo getVendorInfo(String vendorId);
    public VendorInfo getVendorInfoByName(String vendorName);
    public List<VendorInfo> getAllVendorInfo();
}
