package com.jsp.springproject.product.exception;

public class ProductAlreadyExistException extends ProductException {

    public ProductAlreadyExistException(String s) {
        super("   Product Already Exist in the table ");
    }


}
