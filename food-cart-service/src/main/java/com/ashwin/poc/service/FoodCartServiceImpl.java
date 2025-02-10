package com.ashwin.poc.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.entity.FoodCart;
import com.ashwin.poc.exception.CustomException;
import com.ashwin.poc.feignclients.ServicesFeignClient;
import com.ashwin.poc.repository.FoodCartRepository;
import com.ashwin.poc.request.FoodCartRequest;
import com.ashwin.poc.response.FoodCartResponse;
import com.ashwin.poc.response.ItemResponse;

@Service
public class FoodCartServiceImpl implements FoodCartService {

	@Autowired
	FoodCartRepository repository;

	@Autowired
	ServicesFeignClient feignClient;

	@Override
	public FoodCartResponse create(FoodCartRequest cartRequest) {

		FoodCart cart = new FoodCart();
		cart.setCustomerId(cartRequest.getCustomerId());
		cart.setItemsIdwithQuantity(cartRequest.getItemsIdwithQuantity());

		cart = repository.save(cart);

		FoodCartResponse cartResponse = new FoodCartResponse(cart);
		cartResponse.setCustomerResponse(feignClient.getCustomerById(cart.getCustomerId()));

		Map<ItemResponse, Integer> hm = new LinkedHashMap<>();

		cart.getItemsIdwithQuantity().entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		for (Map.Entry<Integer, Integer> m : cart.getItemsIdwithQuantity().entrySet()) {

			hm.put(feignClient.getItemById(m.getKey()), m.getValue());
		}

		cartResponse.setItemsWithQuantity(hm);

		return cartResponse;
	}

	@Override
	public FoodCartResponse getById(Integer cartId) throws CustomException {

		FoodCart cart = repository.findById(cartId)
				.orElseThrow(() -> new CustomException("cart with id: ", cartId, " is not found"));

		FoodCartResponse cartResponse = new FoodCartResponse(cart);
		cartResponse.setCustomerResponse(feignClient.getCustomerById(cart.getCustomerId()));

		LinkedHashMap<ItemResponse, Integer> hm = new LinkedHashMap<>();

		for (Map.Entry<Integer, Integer> m : cart.getItemsIdwithQuantity().entrySet()) {

			hm.put(feignClient.getItemById(m.getKey()), m.getValue());
		}

		cartResponse.setItemsWithQuantity(hm);

		return cartResponse;

	}

	@Override
	public FoodCartResponse getByCustomerId(Integer customerId) {
		FoodCart cart = repository.findByCustomerId(customerId).get();

		FoodCartResponse cartResponse = new FoodCartResponse(cart);
		cartResponse.setCustomerResponse(feignClient.getCustomerById(cart.getCustomerId()));

		LinkedHashMap<ItemResponse, Integer> hm = new LinkedHashMap<>();

		for (Map.Entry<Integer, Integer> m : cart.getItemsIdwithQuantity().entrySet()) {

			hm.put(feignClient.getItemById(m.getKey()), m.getValue());
		}

		cartResponse.setItemsWithQuantity(hm);

		return cartResponse;
	}

	@Override
	public FoodCartResponse updateById(Integer cartId, FoodCartRequest cartRequest) {
		FoodCart cart = repository.findById(cartId).get();
		cart.setCustomerId(cart.getCustomerId());
		cart.setItemsIdwithQuantity(cartRequest.getItemsIdwithQuantity());

		repository.save(cart);

		FoodCartResponse cartResponse = new FoodCartResponse(cart);
		cartResponse.setCustomerResponse(feignClient.getCustomerById(cart.getCustomerId()));

		LinkedHashMap<ItemResponse, Integer> hm = new LinkedHashMap<>();

		for (Map.Entry<Integer, Integer> m : cart.getItemsIdwithQuantity().entrySet()) {

			hm.put(feignClient.getItemById(m.getKey()), m.getValue());
		}

		cartResponse.setItemsWithQuantity(hm);

		return cartResponse;
	}

	@Override
	public void deleteById(Integer cartId) {
		repository.findById(cartId).orElseThrow(() -> new CustomException("cart with id: ", cartId, " is not found"));
		repository.deleteById(cartId);
	}

}
