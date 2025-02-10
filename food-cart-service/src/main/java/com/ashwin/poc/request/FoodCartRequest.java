package com.ashwin.poc.request;

import java.util.Map;

public class FoodCartRequest {

	private int customerId;

	private Map<Integer, Integer> itemsIdwithQuantity;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Map<Integer, Integer> getItemsIdwithQuantity() {
		return itemsIdwithQuantity;
	}

	public void setItemsIdwithQuantity(Map<Integer, Integer> itemsIdwithQuantity) {
		this.itemsIdwithQuantity = itemsIdwithQuantity;
	}

	

	

}
