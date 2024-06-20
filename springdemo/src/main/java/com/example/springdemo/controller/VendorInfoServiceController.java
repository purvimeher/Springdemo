package com.example.springdemo.controller;

import com.example.springdemo.model.VendorInfo;
import com.example.springdemo.service.VendorInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vendorInfo")
public class VendorInfoServiceController {

    VendorInfoService vendorInfoService;

    public VendorInfoServiceController(VendorInfoService vendorInfoService) {
        this.vendorInfoService = vendorInfoService;
    }

    @PostMapping
    public String addVendorInfo(@RequestBody VendorInfo vendorInfo) {
        vendorInfo.setCreatedOn(LocalDateTime.now());
        return vendorInfoService.createVendorInfo(vendorInfo);
    }

    @PutMapping
    public String updateVendorInfo(@RequestBody VendorInfo vendorInfo) {
        vendorInfo.setCreatedOn(LocalDateTime.now());
        return vendorInfoService.updateVendorInfo(vendorInfo);
    }

    @GetMapping("/all")
    public List<VendorInfo> getAllVendorInfo() {
        return vendorInfoService.getAllVendorInfo();
    }

    @GetMapping("{vendorID}")
    public ResponseEntity<VendorInfo> getVendorInfo(@PathVariable String vendorID) {

        VendorInfo result = vendorInfoService.getVendorInfo(vendorID);

        return (result==null)?ResponseEntity.notFound().build() : ResponseEntity.accepted().body(result);

    }

    @DeleteMapping("{vendorID}")
    public String deleteVendorInfo(@PathVariable String vendorID) {

        return vendorInfoService.deleteVendorInfo(vendorID);
    }
}
