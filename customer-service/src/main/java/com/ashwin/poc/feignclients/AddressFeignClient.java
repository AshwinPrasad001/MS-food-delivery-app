package com.ashwin.poc.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashwin.poc.response.AddressResponse;

@FeignClient(value = "apigateway")
public interface AddressFeignClient {

	@GetMapping("/address-service/api/address/getById/{id}")
	public AddressResponse getById(@PathVariable int id);
	
//	@GetMapping("/getByMentionedId/{listOfId}")
//	public List<AddressResponse> getAddressByMentionedId(@PathVariable List<Integer> listOfId);

}
