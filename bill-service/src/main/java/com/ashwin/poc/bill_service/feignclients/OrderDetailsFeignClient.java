package com.ashwin.poc.bill_service.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ashwin.poc.bill_service.response.OrderResponse;


@FeignClient(value = "apigateway")
public interface OrderDetailsFeignClient {

	@GetMapping("order-details/api/order/getByOrderId/{orderId}")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderResponse getOrderDetailsById(@PathVariable Integer orderId);
}
