package com.ashwin.poc.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashwin.poc.response.RestaurantResponse;

@FeignClient(value = "apigateway")
public interface RestaurantFeignClient {

	@GetMapping("/restaurant-service/api/restaurant/getById/{id}")
	public RestaurantResponse getById(@PathVariable int id);

}
