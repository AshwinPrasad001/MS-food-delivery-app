package com.ashwin.poc.bill_service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.bill_service.entity.BillEntity;
import com.ashwin.poc.bill_service.feignclients.OrderDetailsFeignClient;
import com.ashwin.poc.bill_service.repository.BillRepository;
import com.ashwin.poc.bill_service.request.BillRequest;
import com.ashwin.poc.bill_service.response.BillResponse;
import com.ashwin.poc.bill_service.response.ItemResponse;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	BillRepository repository;

	@Autowired
	OrderDetailsFeignClient feignClient;

	@Override
	public BillResponse create(BillRequest request) {

		BillEntity bill = new BillEntity();
		bill.setBillDate(LocalDateTime.now());
		bill.setOrderId(request.getOrderId());

		BillResponse br = new BillResponse(bill);
		br.setOrderResponse(feignClient.getOrderDetailsById(bill.getOrderId()));

		double itemsCost = 0.00;
		int itemListSize = br.getOrderResponse().getCartResponse().getItemsResponse().size();
		for (int i = 0; i < itemListSize; i++) {
			ItemResponse ir = br.getOrderResponse().getCartResponse().getItemsResponse().get(i);
			itemsCost = itemsCost + ir.getCost();
		}

		int totalItem = itemListSize;

		bill.setTotalCost(itemsCost);
		bill.setTotalItem(totalItem);

		repository.save(bill);

		BillResponse billResponse = new BillResponse(bill);
		billResponse.setOrderResponse(feignClient.getOrderDetailsById(bill.getOrderId()));

		return billResponse;
	}

	@Override
	public BillResponse getById(int billId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillResponse updateById(int billId, BillRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillResponse deleteById(int billId) {
		// TODO Auto-generated method stub
		return null;
	}

}
