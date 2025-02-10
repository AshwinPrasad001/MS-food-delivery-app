package com.ashwin.poc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.exception.*;
import com.ashwin.poc.entity.Address;
import com.ashwin.poc.repository.AddressRepository;
import com.ashwin.poc.request.AddressRequest;
import com.ashwin.poc.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public AddressResponse createAddress(AddressRequest request) {

		Address address = new Address();
		address.setArea(request.getArea());
		address.setBuildingName(request.getBuildingName());
		address.setCity(request.getCity());
		address.setCountry(request.getCity());
		address.setPinCode(request.getPinCode());
		address.setState(request.getState());
		address.setStreetNumber(request.getStreetNumber());

		addressRepository.save(address);

		return new AddressResponse(address);
	}

	public AddressResponse getAddressById(int id) {

		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new CustomException("address with id: ", id, "is not found in the repository"));

		AddressResponse addressResponse = new AddressResponse(address);

		return addressResponse;
	}

	public List<AddressResponse> getByMentionedId(List<Integer> listOfId) {

		List<AddressResponse> listOfAddressResponse = new ArrayList<AddressResponse>();

		for (int i = 0; i < listOfId.size(); i++) {
			Address address = new Address();
			int id = listOfId.get(i);
			address = addressRepository.findById(id)
					.orElseThrow(() -> new CustomException("address with id: ", id, "is not found in the repository"));

			AddressResponse addressResponse = new AddressResponse(address);
			listOfAddressResponse.add(addressResponse);
		}

		return listOfAddressResponse;
	}

	public List<AddressResponse> getAddressByPincode(String pinCode) {

		List<Address> listOfAddress = addressRepository.findByPinCode(pinCode);
		List<AddressResponse> listOfAddressResponse = new ArrayList<>();

		for (int i = 0; i < listOfAddress.size(); i++) {
			Address address = new Address();
			address = listOfAddress.get(i);

			AddressResponse addressResponse = new AddressResponse(address);

			listOfAddressResponse.add(addressResponse);

		}
		return listOfAddressResponse;
	}

}
