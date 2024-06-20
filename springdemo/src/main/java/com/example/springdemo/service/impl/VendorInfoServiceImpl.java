package com.example.springdemo.service.impl;

import com.example.springdemo.exception.VendorInforNotFoundException;
import com.example.springdemo.model.VendorInfo;
import com.example.springdemo.repository.VendorInfoRepository;
import com.example.springdemo.service.VendorInfoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        vendorInfoRepository.findById(String.valueOf(vendorInfo.vendorId)).map(vendor -> {
            vendor.name = vendorInfo.name;
            vendor.location = vendorInfo.location;
            vendor.createdOn = LocalDateTime.now();
            vendorInfoRepository.save(vendor);
            return "Updated " + vendorInfo.getVendorId() + "Successfully";
        });
//        vendorInfoRepository.save(vendorInfo);
        return "Successfully updated data in vendor info table";
    }

    @Override
    public String deleteVendorInfo(String vendorId) {
        if (vendorInfoRepository.findById(vendorId).isEmpty()) {
            throw new VendorInforNotFoundException("No vendor is found with id : " + vendorId);
        } else {
            vendorInfoRepository.deleteById(vendorId);
        }
        return "Successfully deleted data from vendor info table";
    }

    @Override
    public VendorInfo getVendorInfo(String vendorId) {
        if (vendorInfoRepository.findById(vendorId).isEmpty())
            throw new VendorInforNotFoundException("No vendor is found with id : " + vendorId);

        return vendorInfoRepository.findById(vendorId).get();

    }

    @Override
    public List<VendorInfo> getAllVendorInfo() {
        if (vendorInfoRepository.findAll().isEmpty())
            throw new VendorInforNotFoundException("No vendors found within the Database");

        return vendorInfoRepository.findAll();
    }
}
