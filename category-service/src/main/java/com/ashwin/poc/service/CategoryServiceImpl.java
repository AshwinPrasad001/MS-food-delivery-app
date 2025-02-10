package com.ashwin.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.entity.Category;
import com.ashwin.poc.exception.CustomException;
import com.ashwin.poc.repository.CategoryRepository;
import com.ashwin.poc.request.CategoryRequest;
import com.ashwin.poc.response.CategoryResponse;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository repository;

	@Override
	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		Category category = new Category();
		category.setCategoryName(categoryRequest.getCategoryName());

		repository.save(category);

		return new CategoryResponse(category);
	}

	@Override
	public CategoryResponse getCategoryById(int id) {
		Category category = repository.findById(id)
				.orElseThrow(() -> new CustomException("address with id: ", id, "is not found in the repository"));

		return new CategoryResponse(category);
	}

	@Override
	public CategoryResponse updateCategoryById(int id, CategoryRequest request) {
		Category category = repository.findById(id)
				.orElseThrow(() -> new CustomException("address with id: ", id, "is not found in the repository"));
		category.setCategoryName(request.getCategoryName());

		repository.save(category);

		return new CategoryResponse(category);
	}

	@Override
	public void deleteCategoryById(int id) {
		repository.findById(id)
				.orElseThrow(() -> new CustomException("address with id: ", id, "is not found in the repository"));
		repository.deleteById(id);
	}
	
	@Override
	public CategoryResponse getCategoryByName(String name) {
		Category category = repository.findByCategoryName(name)
				.orElseThrow(() -> new CustomException("address with name: ", name, "is not found in the repository"));

		return new CategoryResponse(category);
	}

	@Override
	public void deleteCategoryByName(String categoryName) {
		repository.findByCategoryName(categoryName)
				.orElseThrow(() -> new CustomException("address with categoryName: ", categoryName, "is not found in the repository"));
		repository.deleteByCategoryName(categoryName);
	}

	

}
