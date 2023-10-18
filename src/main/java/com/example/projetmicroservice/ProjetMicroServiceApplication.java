package com.example.projetmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProjetMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetMicroServiceApplication.class, args);
	}

}
