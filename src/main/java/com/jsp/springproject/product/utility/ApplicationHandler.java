package com.jsp.springproject.product.utility;

import com.jsp.springproject.product.exception.ProductAlreadyExistException;
import com.jsp.springproject.product.exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springproject.product.exception.ProductNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {
	

	/*@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> productNotFoundByIdException(ProductNotFoundByIdException ex){
		
		ErrorStructure<String> errorStructure = new ErrorStructure<String>();
		errorStructure.setErrorStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setErrorData("Product With The Requested Id Is Not Present!!");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
*/
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorStructure<String>> productAlreadyExistException(ProductException ex){
		ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setErrorStatusCode(HttpStatus.CONFLICT.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setErrorData("Product Already Exist!!");
		return new ResponseEntity<>(errorStructure,HttpStatus.CONFLICT);
	}

}
