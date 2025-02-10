package com.ashwin.poc.response;

import com.ashwin.poc.entity.Customer;

public class CustomerResponse {

	private int customerId;

	private int age;

	private String email;

	private String firstName;

	private String lastName;

	private String gender;

	private String mobileNumber;

	private AddressResponse addressResponse;

	public CustomerResponse(Customer customer) {
		this.customerId = customer.getCustomerId();
		this.age = customer.getAge();
		this.email = customer.getEmail();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.gender = customer.getGender();
		this.mobileNumber = customer.getMobileNumber();
	
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}




	public AddressResponse getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
