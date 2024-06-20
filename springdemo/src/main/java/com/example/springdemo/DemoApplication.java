package com.example.springdemo;

//import com.example.springdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class DemoApplication {

//    @Autowired
//    User user;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
