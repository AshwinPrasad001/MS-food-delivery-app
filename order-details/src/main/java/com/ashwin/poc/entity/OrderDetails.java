package com.ashwin.poc.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "order_date")
	private LocalDateTime orderDate;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "cart_id")
	private int cartId;

	
	
	
	
}















