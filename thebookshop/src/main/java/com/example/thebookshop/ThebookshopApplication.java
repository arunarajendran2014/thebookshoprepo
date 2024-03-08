package com.example.thebookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example"})
public class ThebookshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThebookshopApplication.class, args);
	}

}
