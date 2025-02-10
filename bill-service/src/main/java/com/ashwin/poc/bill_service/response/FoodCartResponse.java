package com.ashwin.poc.bill_service.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodCartResponse {

	private int cartId;

	private CustomerResponse customerResponse;

	private List<ItemResponse> itemsResponse;
}
