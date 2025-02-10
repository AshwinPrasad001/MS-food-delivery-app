package com.ashwin.poc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.entity.Item;
import com.ashwin.poc.feignclients.CategoryFeignClient;
import com.ashwin.poc.repository.ItemRepository;
import com.ashwin.poc.request.ItemRequest;
import com.ashwin.poc.response.ItemResponse;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CategoryFeignClient categoryFeignClient;

	@Autowired
	CommonService commonService;

	public ItemResponse createItem(ItemRequest request) {

		Item item = new Item();

		item.setCost(request.getCost());
		item.setItemName(request.getItemName());
		item.setQuantity(request.getQuantity());

		item.setCategoryId(request.getCategoryId());

		item = itemRepository.save(item);

		ItemResponse itemResponse = new ItemResponse(item);
		itemResponse.setCategoryResponse(commonService.getCategoryById(item.getCategoryId()));

		return itemResponse;
	}

	public ItemResponse getItemById(int id) {
		Item item = itemRepository.findById(id).get();

		ItemResponse itemResponse = new ItemResponse(item);
		itemResponse.setCategoryResponse(commonService.getCategoryById(item.getCategoryId()));

		return itemResponse;
	}

	public List<ItemResponse> getItemsByMentionedId(List<Integer> listOfId) {

		List<ItemResponse> listOfItemResponse = new ArrayList<ItemResponse>();

		for (int i = 0; i < listOfId.size(); i++) {

			Item item = new Item();
			item = itemRepository.findById(listOfId.get(i)).get();

			ItemResponse itemResponse = new ItemResponse(item);
			itemResponse.setCategoryResponse(commonService.getCategoryById(item.getCategoryId()));

			listOfItemResponse.add(itemResponse);

		}

		return listOfItemResponse;
	}

}
