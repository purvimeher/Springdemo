package com.example.springdemo.repository;

import com.example.springdemo.model.Product;
import com.example.springdemo.model.VendorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {


    @Query(
            value = " SELECT * FROM vendor_info_service.product where brand=:brand " +
                    "and brand_category=:brand_category " +
                    "and size_ml=:size_ml", nativeQuery = true)
    Optional<Product> findProductInfoByName(@Param("brand") String brand,
                                               @Param("brand_category") String brand_category,
                                               @Param("size_ml") String size_ml);
}
