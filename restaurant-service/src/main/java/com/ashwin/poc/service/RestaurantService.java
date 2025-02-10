package com.ashwin.poc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.entity.Restaurant;
import com.ashwin.poc.feignclients.AddressFeignClient;
import com.ashwin.poc.repository.RestaurantRepository;
import com.ashwin.poc.request.RestaurantRequest;
import com.ashwin.poc.response.AddressResponse;
import com.ashwin.poc.response.RestaurantResponse;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;

	@Autowired
	AddressFeignClient addressFeignClient;

	public RestaurantResponse createRestaurant(RestaurantRequest request) {

		Restaurant restaurant = new Restaurant();
		restaurant.setManager(request.getManager());
		restaurant.setMobileNumber(request.getMobileNumber());
		restaurant.setPassword(request.getPassword());
		restaurant.setRestaurantName(request.getRestaurantName());
		restaurant.setAddressId(request.getAddressId());
		restaurant.setItems(request.getItemId());

		restaurant = restaurantRepository.save(restaurant);

		RestaurantResponse restaurantResponse = new RestaurantResponse(restaurant);
		restaurantResponse.setAddressResponse(addressFeignClient.getById(restaurant.getAddressId()));
		restaurantResponse.setItemResponse(addressFeignClient.getByMentionedId(restaurant.getItems()));

		return restaurantResponse;
	}

	public RestaurantResponse getRestaurantById(int id) {
		Restaurant restaurant = restaurantRepository.findById(id).get();
		RestaurantResponse restaurantResponse = new RestaurantResponse(restaurant);
		restaurantResponse.setAddressResponse(addressFeignClient.getById(restaurant.getAddressId()));
		restaurantResponse.setItemResponse(addressFeignClient.getByMentionedId(restaurant.getItems()));
		return restaurantResponse;
	}

	public List<RestaurantResponse> getRestaurantByPincode(String pinCode) {
		List<RestaurantResponse> listOfRestaurantResponse = new ArrayList<>();

		List<AddressResponse> listOfAddress = addressFeignClient.getAddressByPincode(pinCode);

		for (int i = 0; i < listOfAddress.size(); i++) {
			AddressResponse address = listOfAddress.get(i);
			
			Restaurant restaurant = restaurantRepository.findByAddressId(address.getAddressId()).get();
			RestaurantResponse restaurantResponse = new RestaurantResponse(restaurant);
			restaurantResponse.setAddressResponse(address);
			restaurantResponse.setItemResponse(addressFeignClient.getByMentionedId(restaurant.getItems()));
			
			listOfRestaurantResponse.add(restaurantResponse);
		}

		return listOfRestaurantResponse;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
