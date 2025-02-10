package com.ashwin.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.poc.response.RegistrationResponse;
import com.ashwin.poc.service.RegistrationService;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	
	public RegistrationResponse createUser() {
		return null;
	}
	
	
}
