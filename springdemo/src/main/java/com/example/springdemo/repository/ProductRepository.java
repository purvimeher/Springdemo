package com.example.springdemo.repository;

import com.example.springdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    @Query(value = " SELECT * FROM vendor_info_service.product where brand=:brand " + "and brand_category=:brand_category " + "and size_ml=:size_ml", nativeQuery = true)
    Optional<Product> findProductInfoByName(@Param("brand") String brand, @Param("brand_category") String brand_category, @Param("size_ml") String size_ml);

    @Query(value = " SELECT * FROM vendor_info_service.product where " + "brand_category=:brand_category ", nativeQuery = true)
    List<Optional<Product>> findProductInfoByCategory(@Param("brand_category") String brand_category);

    @Query(value = " SELECT * FROM vendor_info_service.product where " + "price_duration=:price_duration ", nativeQuery = true)
    List<Optional<Product>> findProductInfoByPriceDuration(@Param("price_duration") String price_duration);

    @Query(value = " SELECT * FROM vendor_info_service.product where " + "size_ml=:size_ml ", nativeQuery = true)
    List<Optional<Product>> findProductInfoBySize(@Param("size_ml") String size_ml);

    @Query(value = " SELECT * FROM vendor_info_service.product where " + "brand=:brand ", nativeQuery = true)
    List<Optional<Product>> findProductInfoByBrandName(@Param("brand") String brand);

    @Query(value = " SELECT * FROM vendor_info_service.product where " + "id=:id ", nativeQuery = true)
    List<Optional<Product>> findProductInfoById(@Param("id") int id);
}
