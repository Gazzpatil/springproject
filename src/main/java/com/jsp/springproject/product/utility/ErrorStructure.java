package com.jsp.springproject.product.utility;

public class ErrorStructure<T> {
	
	private int errorStatusCode;
	private String errorMessage;
	private T errorData;
	public int getErrorStatusCode() {
		return errorStatusCode;
	}
	public void setErrorStatusCode(int errorStatusCode) {
		this.errorStatusCode = errorStatusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public T getErrorData() {
		return errorData;
	}
	public void setErrorData(T errorData) {
		this.errorData = errorData;
	}

}
