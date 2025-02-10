package com.ashwin.poc.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.entity.OrderDetails;
import com.ashwin.poc.exception.CustomException;
import com.ashwin.poc.feignclients.FoodCartFeignClient;
import com.ashwin.poc.repository.OrderDetailsRepository;
import com.ashwin.poc.request.OrderRequest;
import com.ashwin.poc.response.OrderResponse;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsRepository repository;

	@Autowired
	FoodCartFeignClient feignClient;

	@Override
	public OrderResponse create(OrderRequest orderRequest) {

		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrderDate(LocalDateTime.now());
		orderDetails.setOrderStatus(orderRequest.getOrderStatus());
		orderDetails.setCartId(orderRequest.getCartId());

		orderDetails = repository.save(orderDetails);

		OrderResponse orderResponse = new OrderResponse(orderDetails);
		orderResponse.setCartResponse(feignClient.getByCartId(orderDetails.getCartId()));

		return orderResponse;
	}

	@Override
	public OrderResponse getByOrderId(Integer orderId) {

		OrderDetails orderDetails = repository.findById(orderId)
				.orElseThrow(() -> new CustomException("the order with order id:", orderId, "could not be found"));

		OrderResponse orderResponse = new OrderResponse(orderDetails);
		orderResponse.setCartResponse(feignClient.getByCartId(orderDetails.getCartId()));

		return orderResponse;
	}

	@Override
	public OrderResponse update(Integer orderId, OrderRequest orderRequest) {

		OrderDetails orderDetails = repository.findById(orderId)
				.orElseThrow(() -> new CustomException("the order with order id:", orderId, "could not be found"));
		orderDetails.setOrderDate(LocalDateTime.now());
		orderDetails.setOrderStatus(orderRequest.getOrderStatus());
		orderDetails.setCartId(orderDetails.getCartId());

		orderDetails = repository.save(orderDetails);

		OrderResponse orderResponse = new OrderResponse(orderDetails);
		orderResponse.setCartResponse(feignClient.getByCartId(orderDetails.getCartId()));
		return orderResponse;
	}

	@Override
	public void deleteByOrderId(Integer orderId) {
		repository.findById(orderId)
				.orElseThrow(() -> new CustomException("the order with order id:", orderId, "could not be found"));
		repository.deleteById(orderId);
		

	}

}
