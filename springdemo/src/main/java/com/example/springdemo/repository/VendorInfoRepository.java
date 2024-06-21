package com.example.springdemo.repository;

import com.example.springdemo.model.VendorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VendorInfoRepository extends JpaRepository<VendorInfo,String> {
    @Query(
            value = "SELECT * FROM vendor_info_service.vendor_info where name=:name", nativeQuery = true)
    Optional<VendorInfo> findVendorInfoByName(@Param("name") String name);
}
