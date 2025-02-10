package com.ashwin.poc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.entity.Customer;
import com.ashwin.poc.exception.CustomException;
import com.ashwin.poc.feignclients.AddressFeignClient;
import com.ashwin.poc.repository.CustomerRepository;
import com.ashwin.poc.request.CustomerCreateRequest;
import com.ashwin.poc.response.CustomerResponse;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AddressFeignClient addressFeignClient;

	Logger logger = LoggerFactory.getLogger(CustomerService.class);

	public CustomerResponse createCustomer(CustomerCreateRequest customerRequest) {

		Customer customer = new Customer();

		customer.setAge(customerRequest.getAge());
		customer.setFirstName(customerRequest.getFirstName());
		customer.setLastName(customerRequest.getLastName());
		customer.setEmail(customerRequest.getEmail());
		customer.setGender(customerRequest.getGender());
		customer.setMobileNumber(customerRequest.getMobileNumber());
		customer.setEncryptedPassword(customerRequest.getPassword());

		customer.setAddressId(customerRequest.getAddressId());

		customerRepository.save(customer);

		CustomerResponse customerResponse = new CustomerResponse(customer);
		customerResponse.setAddressResponse(addressFeignClient.getById(customer.getAddressId()));

		return customerResponse;
	}

	public CustomerResponse getCustomerById(int id) {

		logger.info("INSIDE GETCUSTOMERBYID");

		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomException("address with id: ", id, "is not found in the repository"));

		CustomerResponse customerResponse = new CustomerResponse(customer);
		customerResponse.setAddressResponse(addressFeignClient.getById(customer.getAddressId()));

		return customerResponse;
	}
}
