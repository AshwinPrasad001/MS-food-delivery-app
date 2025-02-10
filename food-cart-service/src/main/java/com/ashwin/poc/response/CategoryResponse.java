package com.ashwin.poc.response;

public class CategoryResponse {

	private int categoryId;
	private String categoryName;
	
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
	@Override
	public String toString() {
		return "CategoryResponse [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	

}
