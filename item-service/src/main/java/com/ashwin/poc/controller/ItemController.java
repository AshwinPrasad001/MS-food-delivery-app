package com.ashwin.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.poc.request.ItemRequest;
import com.ashwin.poc.response.ItemResponse;
import com.ashwin.poc.service.ItemService;

@RestController
@RequestMapping("/api/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@PostMapping("/create")
	public ItemResponse createItem(@RequestBody ItemRequest request) {
		return itemService.createItem(request);
	}
	
	@GetMapping("/getById/{id}")
	public ItemResponse getItemById(@PathVariable int id) {
		return itemService.getItemById(id);
	}
	
	@GetMapping("/getByMentionedId/{listOfId}")
	public List<ItemResponse> getItemsByMentionedId(@PathVariable List<Integer> listOfId){
		return itemService.getItemsByMentionedId(listOfId);
	}
	
}

















