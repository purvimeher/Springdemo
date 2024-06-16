package com.example.springdemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vendorInfo")
public class VendorInfoServiceController {

    List<VendorInfo> vendorInfoList = new ArrayList<>();
    Map<String,VendorInfo> vendorInfoMap = new HashMap<>();

    @PostMapping
    public String addVendorInfo(@RequestBody VendorInfo vendorInfo){
        vendorInfoMap.put(vendorInfo.getVendorID(), vendorInfo);
        vendorInfoList.add(vendorInfo);
        return "Vendor Successfully Created";
    }

    @GetMapping("all")
    public List<VendorInfo> getAllVendorInfo(){
        return vendorInfoList;
    }

    @GetMapping("{vendorId}")
    public VendorInfo getVendorInfo(String vendorId){
        return vendorInfoMap.get(vendorId);
    }
}
