package com.ashwin.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.entity.RestaurantItems;
import com.ashwin.poc.feignclients.ItemFeignClient;
import com.ashwin.poc.feignclients.RestaurantFeignClient;
import com.ashwin.poc.repository.RestaurantItemsRepository;
import com.ashwin.poc.request.RestaurantItemsRequest;
import com.ashwin.poc.response.ItemResponse;
import com.ashwin.poc.response.RestaurantItemsResponse;
import com.ashwin.poc.response.RestaurantResponse;

@Service
public class RestaurantItemsService {

	@Autowired
	RestaurantItemsRepository repository;

	@Autowired
	RestaurantFeignClient restaurantFeignClient;

	@Autowired
	ItemFeignClient itemFeignClient;

	public RestaurantItems create(RestaurantItemsRequest request) {
		RestaurantItems restaurantItems = new RestaurantItems();
		restaurantItems.setRestaurantId(request.getRestaurantId());
		restaurantItems.setItemId(request.getItemId());
		return repository.save(restaurantItems);
	}

	public RestaurantItemsResponse getById(int restaurantId) {

		RestaurantItems restaurantItems = repository.findByRestaurantId(restaurantId).get();

		RestaurantItemsResponse restaurantItemsResponse = new RestaurantItemsResponse(restaurantItems);

		RestaurantResponse restaurantResponse = restaurantFeignClient.getById(restaurantItems.getRestaurantId());
		restaurantItemsResponse.setRestaurantResponse(restaurantResponse);

		ItemResponse itemResponse = itemFeignClient.getById(restaurantItems.getItemId());
		restaurantItemsResponse.setItemResponse(itemResponse);

		return restaurantItemsResponse;
	}
}
