package com.ashwin.poc.response;

import java.util.List;

import com.ashwin.poc.entity.Restaurant;

public class RestaurantResponse {

	private int restaurantId;

	private String manager;

	private String mobileNumber;

	private String password;

	private String restaurantName;

	private AddressResponse addressResponse;

	private List<ItemResponse> itemResponse;
	
	public RestaurantResponse(Restaurant restaurant) {
		this.restaurantId = restaurant.getRestaurantId();
		this.manager = restaurant.getManager();
		this.mobileNumber = restaurant.getMobileNumber();
		this.password = restaurant.getPassword();
		this.restaurantName = restaurant.getRestaurantName();
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public AddressResponse getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}

	public List<ItemResponse> getItemResponse() {
		return itemResponse;
	}

	public void setItemResponse(List<ItemResponse> itemResponse) {
		this.itemResponse = itemResponse;
	}

}
