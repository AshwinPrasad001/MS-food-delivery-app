package com.ashwin.poc.bill_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@ComponentScan({ "com.ashwin.poc.bill_service.controller", "com.ashwin.poc.bill_service.service",
//		"com.ashwin.poc.bill_service.exception" })
//@EntityScan("com.ashwin.poc.bill_service.entity")
//@EnableJpaRepositories("com.ashwin.poc.bill_service.repository")
//@EnableFeignClients("com.ashwin.poc.bill_service.feignclients")
@EnableFeignClients
@EnableEurekaClient
public class BillServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillServiceApplication.class, args);
	}

}
