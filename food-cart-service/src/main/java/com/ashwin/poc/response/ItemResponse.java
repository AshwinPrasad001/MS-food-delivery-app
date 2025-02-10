package com.ashwin.poc.response;

public class ItemResponse {

	private int itemId;
	private double cost;
	private String itemName;
	private int quantity;
	private CategoryResponse categoryResponse;

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

	@Override
	public String toString() {
		return "ItemResponse [itemId=" + itemId + ", cost=" + cost + ", itemName=" + itemName + ", quantity=" + quantity
				+ ", categoryResponse=" + categoryResponse + "]";
	}
	
	

}
