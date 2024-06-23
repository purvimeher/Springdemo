package com.example.springdemo.controller;

import com.example.springdemo.model.Product;
import com.example.springdemo.response.ResponseHandler;
import com.example.springdemo.service.ProductPriceService;
import com.example.springdemo.utils.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.service.ResponseMessage;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductPriceService fileService;

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadCsvFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();

                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/csv/download/")
                        .path(file.getOriginalFilename())
                        .toUriString();

                return ResponseHandler.responseBuilder("File uploaded successfully", HttpStatus.OK,fileService.getAllProductsFromDb());
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseHandler.responseBuilder("Failed to upload file",HttpStatus.BAD_REQUEST,fileService.getAllProductsFromDb());
            }
        }

        message = "Please upload a csv file!";
        return  ResponseHandler.responseBuilder("Please upload a CSV file",HttpStatus.BAD_REQUEST,"");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = fileService.getAllProductsFromDb();

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
