package com.example.springdemo.controller;

import com.example.springdemo.model.VendorInfo;
import com.example.springdemo.response.ResponseHandler;
import com.example.springdemo.service.VendorInfoService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Object> getVendorInfo(@PathVariable String vendorID) {
        return ResponseHandler.responseBuilder("Requested vendorInfo : " + vendorID, HttpStatus.OK, vendorInfoService.getVendorInfo(vendorID));
//        return vendorInfoService.getVendorInfo(vendorID);
    }

    @GetMapping("name/{vendorName}")
    public ResponseEntity<Object> getVendorInfoByName(@PathVariable String vendorName) {
        return ResponseHandler.responseBuilder("Requested vendorInfo : " + vendorName, HttpStatus.OK, vendorInfoService.getVendorInfoByName(vendorName));
//        return vendorInfoService.getVendorInfo(vendorID);
    }

    @DeleteMapping("{vendorID}")
    public String deleteVendorInfo(@PathVariable String vendorID) {
        return vendorInfoService.deleteVendorInfo(vendorID);
    }
}
