package com.example.springdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vendorInfo")
public class VendorInfoServiceController {

    List<VendorInfo> vendorInfoList = new ArrayList<>();


    @PostMapping
    public String addVendorInfo(@RequestBody VendorInfo vendorInfo){
        vendorInfoList.add(vendorInfo);
        return "Vendor Successfully Created";
    }

    @GetMapping("/all")
    public List<VendorInfo> getAllVendorInfo(){
        return vendorInfoList;
    }

    @GetMapping("{vendorID}")
    public VendorInfo getVendorInfo(@PathVariable String vendorID){
        VendorInfo result =vendorInfoList.stream()
                .filter(vendorInfo -> vendorInfo.getVendorID().equals(vendorID))
                .findFirst()
                .orElse(null);
      return  result;
    }
}
