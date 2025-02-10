package com.ashwin.poc.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashwin.poc.response.FoodCartResponse;

@FeignClient(value = "apigateway")
public interface FoodCartFeignClient {

	@GetMapping("/food-cart-service/api/cart/getByCartId/{cartId}")
	public FoodCartResponse getByCartId(@PathVariable Integer cartId);
}
