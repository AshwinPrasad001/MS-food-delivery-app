package com.ashwin.poc.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashwin.poc.response.CustomerResponse;
import com.ashwin.poc.response.ItemResponse;

@FeignClient(value = "apigateway")
public interface ServicesFeignClient {

	@GetMapping("/customer-service/api/customer/getById/{id}")
	public CustomerResponse getCustomerById(@PathVariable int id);
	
	@GetMapping("/item-service/api/item/getById/{id}")
	public ItemResponse getItemById(@PathVariable int id);
	
	@GetMapping("/item-service/api/item/getByMentionedId/{listOfId}")
	public List<ItemResponse> getItemsByMentionedId(@PathVariable List<Integer> listOfId);
	
}
