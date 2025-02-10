package com.ashwin.poc.request;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

	private LocalDateTime localDateTime = LocalDateTime.now();

	private String orderStatus;

	private int cartId;

}
