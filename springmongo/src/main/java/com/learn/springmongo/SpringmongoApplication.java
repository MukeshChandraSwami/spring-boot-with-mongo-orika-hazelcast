package com.learn.springmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmongoApplication.class, args);
	}

}
