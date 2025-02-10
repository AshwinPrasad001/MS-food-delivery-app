package com.ashwin.poc.response;

import java.util.Map;

import com.ashwin.poc.entity.FoodCart;

public class FoodCartResponse {

	private int cartId;

	private CustomerResponse customerResponse;

	private Map<ItemResponse, Integer> itemsWithQuantity;

	public FoodCartResponse(FoodCart cart) {
		this.cartId = cart.getCartId();
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public CustomerResponse getCustomerResponse() {
		return customerResponse;
	}

	public void setCustomerResponse(CustomerResponse customerResponse) {
		this.customerResponse = customerResponse;
	}

	public Map<ItemResponse, Integer> getItemsWithQuantity() {
		return itemsWithQuantity;
	}

	public void setItemsWithQuantity(Map<ItemResponse, Integer> itemsWithQuantity) {
		this.itemsWithQuantity = itemsWithQuantity;
	}

	

	

}
