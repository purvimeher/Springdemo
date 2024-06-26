package com.ppmm.springdemoexample.chapter.misc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {

    private final String engineCapacity;

    public Engine(@Value("1000cc") String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Engine{" + "engineCapacity='" + engineCapacity + '\'' + '}';
    }
}
