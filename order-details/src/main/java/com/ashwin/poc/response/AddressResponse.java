package com.ashwin.poc.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

	private int addressId;
	private String area;
	private String buildingName;
	private String city;
	private String country;
	private String pinCode;
	private String state;
	private String streetNumber;

	

}
