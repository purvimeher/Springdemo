package com.ppmm.springdemoexample.chapter.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    @Autowired
    private Car myCar;

    public Person(Car myCar) {
        this.myCar = myCar;
    }

    public void canEat() {
        System.out.println("Eating");
    }

    public Car getMyCar() {
        return myCar;
    }

    @Override
    public String toString() {
        return "Person{" +
                "myCar=" + myCar +
                '}';
    }
}
