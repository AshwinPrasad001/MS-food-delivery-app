package com.ashwin.poc.bill_service.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {

	private int orderId;

	private LocalDateTime orderDate;

	private String orderStatus;

	private FoodCartResponse cartResponse;
}
