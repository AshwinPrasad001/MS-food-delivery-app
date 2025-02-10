package com.ashwin.poc.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ashwin.poc.response.CategoryResponse;

@FeignClient(value = "apigateway")
public interface CategoryFeignClient {

	@GetMapping("/category-service/api/category/getById/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CategoryResponse getById(@PathVariable int id);
}
