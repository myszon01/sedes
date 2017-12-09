package com.freight.crm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class SedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SedesApplication.class, args);
	}
	
	
	 @Bean
	    public CommandLineRunner runner( TestRepository testRepository){
	        return (args) -> {
	            testRepository.findAll().forEach(System.out::println);
	        };
	    }
	
}
