package com.ashwin.poc.exception;

public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1585033875641040884L;
	
	public String former;
	public Object value;
	public String latter;
	
	public CustomException(String former, Object value, String latter) {
		super(String.format("%s '%s' %s",former, value ,latter));
		this.former = former;
		this.value = value;
		this.latter = latter;
	}
	
	
	
}
