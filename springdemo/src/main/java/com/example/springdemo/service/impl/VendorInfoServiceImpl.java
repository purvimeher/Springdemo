package com.example.springdemo.service.impl;

import com.example.springdemo.model.VendorInfo;
import com.example.springdemo.repository.VendorInfoRepository;
import com.example.springdemo.service.VendorInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorInfoServiceImpl implements VendorInfoService {
    VendorInfoRepository vendorInfoRepository;

    public VendorInfoServiceImpl(VendorInfoRepository vendorInfoRepository) {
        this.vendorInfoRepository = vendorInfoRepository;
    }

    @Override
    public String createVendorInfo(VendorInfo vendorInfo) {
        vendorInfoRepository.save(vendorInfo);
        return "Successfully inserted data into vendor info table";
    }

    @Override
    public String updateVendorInfo(VendorInfo vendorInfo) {
        vendorInfoRepository.save(vendorInfo);
        return "Successfully updated data in vendor info table";
    }

    @Override
    public String deleteVendorInfo(String vendorId) {
        vendorInfoRepository.deleteById(vendorId);
        return "Successfully deleted data from vendor info table";
    }

    @Override
    public VendorInfo getVendorInfo(String vendorId) {
        return vendorInfoRepository.findById(vendorId).get();

    }

    @Override
    public List<VendorInfo> getAllVendorInfo() {
        return vendorInfoRepository.findAll();
    }
}
