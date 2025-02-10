package com.ashwin.poc.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashwin.poc.response.ItemResponse;

@FeignClient(value = "apigateway")
public interface ItemFeignClient {
	
	@GetMapping("/item-service/api/item/getById/{id}")
	public ItemResponse getById(@PathVariable int id);

}
