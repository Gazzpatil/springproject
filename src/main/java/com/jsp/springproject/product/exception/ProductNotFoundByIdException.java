package com.jsp.springproject.product.exception;

public class ProductNotFoundByIdException extends ProductException{

	public ProductNotFoundByIdException(String s) {
		super("Product Not Found By Id Exception");
	}
}
