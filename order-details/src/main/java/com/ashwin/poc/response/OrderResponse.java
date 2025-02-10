package com.ashwin.poc.response;

import java.time.LocalDateTime;

import com.ashwin.poc.entity.OrderDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {

	private int orderId;
	
	private LocalDateTime orderDate;
	
	private String orderStatus;
	
	private FoodCartResponse cartResponse;

	public OrderResponse(OrderDetails orderDetails) {
		this.orderId = orderDetails.getOrderId();
		this.orderDate=orderDetails.getOrderDate();
		this.orderStatus=orderDetails.getOrderStatus();
	}
	
	
	
	
	
}
