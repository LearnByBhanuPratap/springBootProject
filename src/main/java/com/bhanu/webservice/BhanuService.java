package com.bhanu.webservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.bhanu.webservice.dao"})
public class BhanuService {
	
	public static void main(String[] args) {
		SpringApplication.run(BhanuService.class, args);	
	}
	
}
