package com.ashwin.poc.food_cart_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.ashwin.poc.controller","com.ashwin.poc.service","com.ashwin.poc.exception"})
@EntityScan("com.ashwin.poc.entity")
@EnableJpaRepositories("com.ashwin.poc.repository")
@EnableFeignClients("com.ashwin.poc.feignclients")
@EnableEurekaClient
public class FoodCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodCartServiceApplication.class, args);
	}

}
