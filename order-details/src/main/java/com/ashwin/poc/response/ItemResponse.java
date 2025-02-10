package com.ashwin.poc.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponse {

	private int itemId;
	private double cost;
	private String itemName;
	private int quantity;
	private CategoryResponse categoryResponse;

	

}
