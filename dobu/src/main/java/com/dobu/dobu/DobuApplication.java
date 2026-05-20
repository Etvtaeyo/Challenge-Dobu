package com.dobu.dobu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DobuApplication {

	public static void main(String[] args) {
		SpringApplication.run(DobuApplication.class, args);
	}

}
