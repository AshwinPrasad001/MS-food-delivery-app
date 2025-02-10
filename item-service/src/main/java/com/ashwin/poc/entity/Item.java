package com.ashwin.poc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int id;
	
	@Column(name = "cost")
	private double cost;
	
	@Column(name = "item_name")
	private String name;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "category_id")
	private int categoryId;

	
	public int getItemId() {
		return id;
	}

	public void setItemId(int itemId) {
		this.id = itemId;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getItemName() {
		return name;
	}

	public void setItemName(String itemName) {
		this.name = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
}
