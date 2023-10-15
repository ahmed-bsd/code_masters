package com.example.eurekaapplicarion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicarionApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicarionApplication.class, args);
    }

}
