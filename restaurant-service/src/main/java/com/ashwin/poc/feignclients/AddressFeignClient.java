package com.ashwin.poc.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashwin.poc.response.AddressResponse;
import com.ashwin.poc.response.ItemResponse;

@FeignClient(value = "apigateway")
public interface AddressFeignClient {

	@GetMapping("/address-service/api/address/getById/{id}")
	public AddressResponse getById(@PathVariable int id);
	
	@GetMapping("/item-service/api/item/getByMentionedId/{listOfId}")
	@CollectionFormat(feign.CollectionFormat.CSV)
	public List<ItemResponse> getByMentionedId(@PathVariable List<Integer> listOfId);
	
	@GetMapping("/address-service/api/address/getByPinCode/{pinCode}")
	public List<AddressResponse> getAddressByPincode(@PathVariable String pinCode);
}
