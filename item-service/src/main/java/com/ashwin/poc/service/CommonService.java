package com.ashwin.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.feignclients.CategoryFeignClient;
import com.ashwin.poc.response.CategoryResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
	@Autowired
	CategoryFeignClient categoryFeignClient;

	@CircuitBreaker(name = "categoryService",fallbackMethod = "fallbackGetCategoryById")
	public CategoryResponse getCategoryById(int categoryId) {
		CategoryResponse categoryResponse = categoryFeignClient.getById(categoryId);
		
		return categoryResponse;
	}
	
	public CategoryResponse fallbackGetCategoryById(int categoryId, Throwable th) {
		return new CategoryResponse();
	}
}
