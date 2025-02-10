package com.ashwin.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.poc.entity.RestaurantItems;
import com.ashwin.poc.request.RestaurantItemsRequest;
import com.ashwin.poc.response.RestaurantItemsResponse;
import com.ashwin.poc.service.RestaurantItemsService;

@RestController
@RequestMapping("/api/restaurant-items")
public class RestaurantItemsController {

	@Autowired
	RestaurantItemsService service;
	
	@PostMapping("/create")
	public RestaurantItems create(@RequestBody RestaurantItemsRequest request) {
		return service.create(request);
	}
	
	@GetMapping("/getById/{restaurantId}")
	public RestaurantItemsResponse getById(@PathVariable int restaurantId) {
		return service.getById(restaurantId);
	}
	
}
