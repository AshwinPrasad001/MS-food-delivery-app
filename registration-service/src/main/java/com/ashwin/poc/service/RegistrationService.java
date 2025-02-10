package com.ashwin.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.poc.entity.Registration;
import com.ashwin.poc.repository.RegistrationRepository;
import com.ashwin.poc.request.RegistrationRequest;
import com.ashwin.poc.response.RegistrationResponse;

@Service
public class RegistrationService {

	@Autowired
	RegistrationRepository registrationRepository;
	
	public RegistrationResponse createUser(RegistrationRequest registrationRequest) {
		
		Registration registration = new Registration();
		
		registration.setLocalDateTime(registrationRequest.getLocalDateTime());
		registration.setUuid(registrationRequest.getUuid());
		
		registrationRepository.save(registration);
		
		return new RegistrationResponse(registration);	
	}
	
	public RegistrationResponse getUserById(int id) {
		
		
		return null;
	}
	
}
