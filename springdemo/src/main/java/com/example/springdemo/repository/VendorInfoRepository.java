package com.example.springdemo.repository;

import com.example.springdemo.model.VendorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorInfoRepository extends JpaRepository<VendorInfo,String> {
}
