package com.ppmm.springdemoexample.chapter.misc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {

    private final String engineCapacity;

    public Engine(@Value("${engineCapacity}") String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Engine{" + "engineCapacity='" + engineCapacity + '\'' + '}';
    }
}
