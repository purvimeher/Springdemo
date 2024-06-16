package com.example.springdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vendorInfo")
public class VendorInfoServiceController {

    List<VendorInfo> vendorInfoList = new ArrayList<>();


    @PostMapping
    public String addVendorInfo(@RequestBody VendorInfo vendorInfo) {
        vendorInfo.setCreatedOn(LocalDateTime.now());
        vendorInfoList.add(vendorInfo);

        return "Vendor Successfully Created";
    }

    @GetMapping("/all")
    public List<VendorInfo> getAllVendorInfo() {
        return vendorInfoList;
    }

    @GetMapping("{vendorID}")
    public ResponseEntity<VendorInfo> getVendorInfo(@PathVariable String vendorID) {
        VendorInfo result = vendorInfoList.stream().filter(vendorInfo -> vendorInfo.getVendorID().equals(vendorID)).findFirst().orElse(null);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.accepted().body(result);
        }
    }
}
