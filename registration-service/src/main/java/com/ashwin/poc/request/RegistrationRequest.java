package com.ashwin.poc.request;

import java.time.LocalDateTime;

public class RegistrationRequest {

	private LocalDateTime localDateTime;
	private String uuid;
	
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
