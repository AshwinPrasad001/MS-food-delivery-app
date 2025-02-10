package com.ashwin.poc.service;

import com.ashwin.poc.request.FoodCartRequest;
import com.ashwin.poc.response.FoodCartResponse;

public interface FoodCartService {

	public FoodCartResponse create(FoodCartRequest cartRequest);
	public FoodCartResponse getById(Integer cartId);
	public FoodCartResponse getByCustomerId(Integer customerId);
	public void deleteById(Integer cartId);
	public FoodCartResponse updateById(Integer cartId, FoodCartRequest cartRequest);
	
}
