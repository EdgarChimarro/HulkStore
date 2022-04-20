package com.todo1.hulkstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
public class HulkStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreApplication.class, args);
	}

	@Bean
	SpringDataDialect springDataDialect() {
	  return new SpringDataDialect();  
	} 
}
