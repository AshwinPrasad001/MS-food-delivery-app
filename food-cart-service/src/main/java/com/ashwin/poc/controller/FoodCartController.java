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
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.poc.request.FoodCartRequest;
import com.ashwin.poc.response.FoodCartResponse;
import com.ashwin.poc.service.FoodCartServiceImpl;

@RestController
@RequestMapping("/api/cart")
public class FoodCartController {

	@Autowired
	FoodCartServiceImpl cartService;

	@PostMapping("/create")
	public ResponseEntity<FoodCartResponse> createCart(@RequestBody FoodCartRequest cartRequest) {
		return new ResponseEntity<>(cartService.create(cartRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getByCartId/{cartId}")
	public FoodCartResponse getByCartId(@PathVariable Integer cartId) {
		return cartService.getById(cartId);
	}

	@GetMapping("/getByCustomerId/{customerId}")
	public FoodCartResponse getByCustomerId(@PathVariable Integer customerId) {
		return cartService.getByCustomerId(customerId);
	}
	
	@PutMapping("/update/{cartId}")
	public FoodCartResponse updateByCustomerId(@PathVariable Integer cartId, @RequestBody FoodCartRequest cartRequest) {
		return cartService.updateById(cartId, cartRequest);
	}

	@DeleteMapping("/deleteById/{cartId}")
	public ResponseEntity<Void> deleteCartById(@PathVariable Integer cartId) {
		cartService.deleteById(cartId);
		return ResponseEntity.noContent().build();
	}
}
