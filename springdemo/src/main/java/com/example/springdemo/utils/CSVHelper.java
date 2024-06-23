package com.example.springdemo.utils;

import com.example.springdemo.model.Product;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"SL_NO", "BRAND_CATEGORY", "BRAND", "SIZE_ML", "MAXIMUM_RETAIL_PRICE_PER_BOTTLE","PRICE_DURATION"};

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType()) || file.getContentType().equals("application/vnd.ms-excel");
    }

    public static List<Product> csvToProducts(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)); CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Product> productList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Product product = new Product(csvRecord.get("BRAND_CATEGORY"), csvRecord.get("BRAND"), csvRecord.get("SIZE_ML"), Double.valueOf(csvRecord.get("MAXIMUM_RETAIL_PRICE_PER_BOTTLE")),csvRecord.get("PRICE_DURATION"));

                productList.add(product);
            }

            return productList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

   public static ByteArrayInputStream productsToCSV(List<Product> productList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Product product : productList) {
                List<String> data = Arrays.asList(
                        String.valueOf(product.Id),
                        product.getBrand_category(),
                        product.getBrand(),
                        product.getSize_ml(),
                        String.valueOf(product.getMaximum_retail_price_per_bottle()),
                        product.getPrice_duration()
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}