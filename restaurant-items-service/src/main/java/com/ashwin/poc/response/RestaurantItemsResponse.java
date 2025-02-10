package com.ashwin.poc.response;

import com.ashwin.poc.entity.RestaurantItems;

public class RestaurantItemsResponse {

	private int id;
	
	private int restaurantId;
	
	private int itemId;
	
	private RestaurantResponse restaurantResponse;

	private ItemResponse itemResponse;
	
	
	public RestaurantItemsResponse(RestaurantItems restaurantItems) {
		this.id = restaurantItems.getId();
		this.restaurantId = restaurantItems.getRestaurantId();
		this.itemId = restaurantItems.getItemId();
	}
	

	public RestaurantResponse getRestaurantResponse() {
		return restaurantResponse;
	}

	public void setRestaurantResponse(RestaurantResponse restaurantResponse) {
		this.restaurantResponse = restaurantResponse;
	}

	public ItemResponse getItemResponse() {
		return itemResponse;
	}

	public void setItemResponse(ItemResponse itemResponse) {
		this.itemResponse = itemResponse;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
