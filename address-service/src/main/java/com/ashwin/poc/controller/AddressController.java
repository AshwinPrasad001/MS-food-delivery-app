package com.ashwin.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.poc.request.AddressRequest;
import com.ashwin.poc.response.AddressResponse;
import com.ashwin.poc.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	
	@Value("${address.test}")
	private String test;
	
	
	@PostMapping("/create")
	public AddressResponse create(@RequestBody AddressRequest addressRequest) {
		return addressService.createAddress(addressRequest);
	}
	
	@GetMapping("/getById/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public AddressResponse getById(@PathVariable int id) {
		return addressService.getAddressById(id);
	}
	
	@GetMapping("/getByMentionedId/{listOfId}")
	public List<AddressResponse> getAddressByMentionedId(@PathVariable List<Integer> listOfId){
		return addressService.getByMentionedId(listOfId);
	}
	
	@GetMapping("/getByPinCode/{pinCode}")
	public List<AddressResponse> getAddressByPincode(@PathVariable String pinCode){		
		return addressService.getAddressByPincode(pinCode);
	}
	
	@GetMapping("/test")
	public String test() {
		return test;
	}
	
	
}















