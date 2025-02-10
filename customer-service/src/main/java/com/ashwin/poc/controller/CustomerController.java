package com.ashwin.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.poc.request.CustomerCreateRequest;
import com.ashwin.poc.response.CustomerResponse;
import com.ashwin.poc.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/create")
	public CustomerResponse createCustomer(@RequestBody CustomerCreateRequest customerRequest) {
		return customerService.createCustomer(customerRequest);
	}
	@GetMapping("/getById/{id}")
	public CustomerResponse getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
}
