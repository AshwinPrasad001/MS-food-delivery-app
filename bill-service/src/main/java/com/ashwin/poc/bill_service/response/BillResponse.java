package com.ashwin.poc.bill_service.response;

import java.time.LocalDateTime;

import com.ashwin.poc.bill_service.entity.BillEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillResponse {

	private int billId;
	private LocalDateTime billDate;
	private double totalCost;
	private int totalItem;
	private OrderResponse orderResponse;

	public BillResponse(BillEntity bill) {
		this.billId = bill.getBillId();
		this.billDate = bill.getBillDate();
		this.totalCost = bill.getTotalCost();
		this.totalItem = bill.getTotalItem();
	}

}
