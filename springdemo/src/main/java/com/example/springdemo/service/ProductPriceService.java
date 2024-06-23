package com.example.springdemo.service;

import com.example.springdemo.model.Product;
import com.example.springdemo.repository.ProductRepository;
import com.example.springdemo.utils.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ProductPriceService {
    @Autowired
    ProductRepository productRepository;

    public void save(MultipartFile file) {
        try {
            List<Product> tutorials = CSVHelper.csvToProducts(file.getInputStream());
            productRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Product> products = productRepository.findAll();

        ByteArrayInputStream in = CSVHelper.productsToCSV(products);
        return in;
    }

    public List<Product> getAllProductsFromDb() {
        return productRepository.findAll();
    }
}
