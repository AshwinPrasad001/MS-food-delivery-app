package com.ashwin.poc.service;

import com.ashwin.poc.request.OrderRequest;
import com.ashwin.poc.response.OrderResponse;

public interface OrderDetailsService {

	public OrderResponse create(OrderRequest orderRequest); 
	public OrderResponse getByOrderId(Integer orderId);
	public OrderResponse update(Integer orderId, OrderRequest orderRequest);
	public void deleteByOrderId(Integer orderId);
}
