package com.example.springdemo.constants;

public enum ProductName {
    BIO("B.I.O"),
    BEER("BEER"),
    DELUXE_PREMIUM_BRAND("DELUXE PREMIUM BRAND"),
    DELUXE_PRESTIGE_BRAND("DELUXE PRESTIGE BRAND"),
    PREMIUM_BRAND("PREMIUM BRAND"),
    SEMI_PREMIUM_BRAND("SEMI PREMIUM BRAND"),
    SUPER_PREMIUM_BRAND("SUPER PREMIUM BRAND"),
    WINE("WINE");

    private final String productName;

   private  ProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
