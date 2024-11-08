package com.jsp.springproject.product.productservice;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jsp.springproject.product.productentity.Product;
import com.jsp.springproject.product.utility.ResponseStructure;

import java.util.List;

public interface ProductService {
	
	public ResponseEntity<ResponseStructure<Product>> addProduct(Product product);


	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId);
	
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updatedProduct);
	
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);

//	public ResponseEntity<ResponseStructure<Product>> findAllByProductId(int productId);

	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts();

}
