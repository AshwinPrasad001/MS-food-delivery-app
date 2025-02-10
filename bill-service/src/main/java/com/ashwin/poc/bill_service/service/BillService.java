package com.ashwin.poc.bill_service.service;

import com.ashwin.poc.bill_service.request.BillRequest;
import com.ashwin.poc.bill_service.response.BillResponse;

public interface BillService {

	public BillResponse create(BillRequest request);

	public BillResponse getById(int billId);

	public BillResponse updateById(int billId, BillRequest request);

	public BillResponse deleteById(int billId);
}
