package com.example.immoprojectmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
public class ImmoProjectMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImmoProjectMicroserviceApplication.class, args);
	}

}
