package com.ashwin.poc.response;

import java.time.LocalDateTime;

import com.ashwin.poc.entity.Registration;

public class RegistrationResponse {

	private int userId;
	
	private LocalDateTime localDateTime;
	
	private String uuid;
	
	

	public RegistrationResponse(Registration registration) {
		this.userId = registration.getUserId();
		this.localDateTime = registration.getLocalDateTime();
		this.uuid = registration.getUuid();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	
}
