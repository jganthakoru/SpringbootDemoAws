package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.demo.model")
@EnableJpaRepositories
public class SpringBootCurdDemoApplication {

	public static void main(String[] args) {
				
		SpringApplication.run(SpringBootCurdDemoApplication.class, args);
	}
	
}
