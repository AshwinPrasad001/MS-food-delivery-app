package com.ashwin.poc.exception;

public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1386984728757664800L;

	public String former;
	public Object value;
	public String latter;

	public CustomException(String former, Object value, String latter) {
		super(String.format("%s '%s' %s", former, value, latter));
		this.former = former;
		this.value = value;
		this.latter = latter;
	}

	public String getFormer() {
		return former;
	}

	public void setFormer(String former) {
		this.former = former;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getLatter() {
		return latter;
	}

	public void setLatter(String latter) {
		this.latter = latter;
	}

}
