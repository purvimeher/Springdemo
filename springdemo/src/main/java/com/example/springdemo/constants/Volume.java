package com.example.springdemo.constants;

public enum Volume {
    ML_1000("1000_ML"),
    ML_750("750_ML"),
    ML_600("600_ML"),
    ML_500("500_ML"),
    ML_375("375_ML"),
    ML_180("180_ML");

    private final String volume;

    private Volume(String volume) {
        this.volume = volume;
    }

    public String getVolume() {
        return volume;
    }
}
