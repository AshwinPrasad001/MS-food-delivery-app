package com.ashwin.poc.bill_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.poc.bill_service.request.BillRequest;
import com.ashwin.poc.bill_service.response.BillResponse;
import com.ashwin.poc.bill_service.service.BillServiceImpl;

@RestController
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	BillServiceImpl service;
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.OK)
	public BillResponse createBill(@RequestBody BillRequest request) {
		return service.create(request);
	}
}






