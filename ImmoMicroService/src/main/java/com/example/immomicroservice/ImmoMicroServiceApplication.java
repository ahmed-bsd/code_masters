package com.example.immomicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ImmoMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmoMicroServiceApplication.class, args);
    }

}
