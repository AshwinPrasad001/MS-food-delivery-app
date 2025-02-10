package com.ashwin.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.poc.request.OrderRequest;
import com.ashwin.poc.response.OrderResponse;
import com.ashwin.poc.service.OrderDetailsServiceImpl;

@RestController
@RequestMapping("/api/order")
public class OrderDetailsController {

	@Autowired
	OrderDetailsServiceImpl service;
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrderResponse createOrderDetails(@RequestBody OrderRequest orderRequest) {
		return service.create(orderRequest);
	}
	
	@GetMapping("/getByOrderId/{orderId}")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderResponse getOrderDetailsById(@PathVariable Integer orderId) {
		return service.getByOrderId(orderId);
	}
	
	@PutMapping("/update/{orderId}")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderResponse updateOrderDetailsByOrderId(@PathVariable Integer orderId, @RequestBody OrderRequest orderRequest) {
		return service.update(orderId, orderRequest);
	}
	
	@DeleteMapping("/deleteByOrderId/{orderId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<String> deleteOrderDetailsById(@PathVariable Integer orderId) {
		 service.deleteByOrderId(orderId);
		 return ResponseEntity.ok("Order with orderID: "+orderId+" was deleted successfully!");
	}
}















