package com.ashwin.poc.response;

import com.ashwin.poc.entity.Item;

public class ItemResponse {
	
	private int itemId;
	private double cost;
	private String itemName;
	private int quantity;
	private CategoryResponse categoryResponse;
	
	
	public ItemResponse(Item item) {
		this.itemId = item.getItemId();
		this.cost = item.getCost();
		this.itemName = item.getItemName();
		this.quantity = item.getQuantity();
	}
	
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CategoryResponse getCategoryResponse() {
		return categoryResponse;
	}
	public void setCategoryResponse(CategoryResponse categoryResponse) {
		this.categoryResponse = categoryResponse;
	}


	
	


}
