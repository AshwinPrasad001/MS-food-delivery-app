package com.ashwin.poc.service;

import com.ashwin.poc.request.CategoryRequest;
import com.ashwin.poc.response.CategoryResponse;

public interface CategoryService {

	public CategoryResponse createCategory(CategoryRequest categoryRequest);
	public CategoryResponse getCategoryById(int id);
	public CategoryResponse getCategoryByName(String name);
	public CategoryResponse updateCategoryById(int id, CategoryRequest request);
	public void deleteCategoryById(int id);
	public void deleteCategoryByName(String categoryName);
}
