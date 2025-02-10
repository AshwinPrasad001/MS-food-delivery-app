package com.ashwin.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.poc.request.RestaurantRequest;
import com.ashwin.poc.response.RestaurantResponse;
import com.ashwin.poc.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	@PostMapping("/create")
	public RestaurantResponse create(@RequestBody RestaurantRequest request) {
		return restaurantService.createRestaurant(request);
	}
	
	@GetMapping("/getById/{id}")
	public RestaurantResponse getById(@PathVariable int id) {
		return restaurantService.getRestaurantById(id);
	}
	
	@GetMapping("/getByPincode/{pincode}")
	public List<RestaurantResponse> getByRestaurantPincode(@PathVariable String pincode ){
		return restaurantService.getRestaurantByPincode(pincode);
	}
	
}
















