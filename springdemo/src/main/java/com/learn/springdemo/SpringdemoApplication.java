package com.learn.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan("com.learn")
public class SpringdemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringdemoApplication.class, args);
	}

}
