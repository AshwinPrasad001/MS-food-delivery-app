package com.ashwin.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.poc.request.CategoryRequest;
import com.ashwin.poc.response.CategoryResponse;
import com.ashwin.poc.service.CategoryServiceImpl;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	CategoryServiceImpl categoryService;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CategoryResponse create(@RequestBody CategoryRequest request) {
		return categoryService.createCategory(request);
	}

	@GetMapping("/getById/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CategoryResponse getById(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}
	
	@GetMapping("/getByName/{name}")
	@ResponseStatus(code = HttpStatus.OK)
	public CategoryResponse getByCategoryName(@PathVariable String name) {
		return categoryService.getCategoryByName(name);
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CategoryResponse updateById(@PathVariable int id, @RequestBody CategoryRequest request) {
		return categoryService.updateCategoryById(id, request);
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<String> deleteOrderDetailsById(@PathVariable int id) {
		 categoryService.deleteCategoryById(id);
		 return ResponseEntity.ok("Category with ID:"+id+"was deleted successfully!");
	}
	
	@DeleteMapping("/deleteByName/{name}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<String> deleteOrderDetailsById(@PathVariable String name) {
		 categoryService.deleteCategoryByName(name);
		 return ResponseEntity.ok("Category with name:"+name+"was deleted successfully!");
	}

}
