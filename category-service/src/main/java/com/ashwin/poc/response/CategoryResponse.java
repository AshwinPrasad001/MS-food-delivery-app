package com.ashwin.poc.response;

import com.ashwin.poc.entity.Category;

public class CategoryResponse {

	private int categoryId;
	private String categoryName;

	public CategoryResponse(Category category) {
		this.categoryId = category.getCategoryId();
		this.categoryName = category.getCategoryName();
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
