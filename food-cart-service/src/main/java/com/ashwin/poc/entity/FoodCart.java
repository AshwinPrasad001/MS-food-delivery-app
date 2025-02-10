package com.ashwin.poc.entity;

import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FoodCart")
public class FoodCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	private int customerId;

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Integer, Integer> items;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Map<Integer, Integer> getItemsIdwithQuantity() {
		return items;
	}

	public void setItemsIdwithQuantity(Map<Integer, Integer> itemsIdwithQuantity) {
		this.items = itemsIdwithQuantity;
	}

}
