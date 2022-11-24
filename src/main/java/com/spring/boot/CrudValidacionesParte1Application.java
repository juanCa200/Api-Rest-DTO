package com.spring.boot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudValidacionesParte1Application {

	@Bean
	public ModelMapper mapear() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CrudValidacionesParte1Application.class, args);
	}

}
