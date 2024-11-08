package com.jsp.springproject.product.exception;

public class ProductException extends RuntimeException {

    private String message;
    public ProductException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
