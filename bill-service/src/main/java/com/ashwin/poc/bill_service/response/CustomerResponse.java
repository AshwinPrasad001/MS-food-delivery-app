package com.ashwin.poc.bill_service.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {

	private int customerId;

	private int age;

	private String email;

	private String firstName;

	private String lastName;

	private String gender;

	private String mobileNumber;

	private AddressResponse addressResponse;
}
