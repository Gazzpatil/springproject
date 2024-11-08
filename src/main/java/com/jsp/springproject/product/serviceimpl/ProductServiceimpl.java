package com.jsp.springproject.product.serviceimpl;

import java.util.List;
import java.util.Optional;

import com.jsp.springproject.product.exception.ProductAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springproject.product.exception.ProductNotFoundByIdException;
import com.jsp.springproject.product.productentity.Product;
import com.jsp.springproject.product.productrepository.ProductRepository;
import com.jsp.springproject.product.productservice.ProductService;
import com.jsp.springproject.product.utility.ResponseStructure;
@Service
public class ProductServiceimpl implements ProductService{


	private ProductRepository productRepository;
	private ResponseStructure<Product> structure;

	ProductServiceimpl(ProductRepository productRepository,ResponseStructure structure){
		this.productRepository=productRepository;
		this.structure=structure;

	}


	public ResponseEntity<ResponseStructure<Product>> addProduct(Product product) {
		System.out.println("product price is: "+product.getProductPrice());
		
		if(productRepository.findById(product.getProductId()).isPresent()){
			throw new ProductAlreadyExistException("Product  already exists in the table");
		}

		Product product2 = productRepository.save(product);
		ResponseStructure<Product> responseStructure= new ResponseStructure<Product>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Product Object added Successfully!!");
		responseStructure.setData(product2);

		return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);

	}





	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId) {
		//		Optional<Product> optional = productRepository.findById(productId);
		//
		//		if(optional.isPresent()) {
		//			Product product = optional.get();
		//			
		//			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		//			responseStructure.setStatuscode(HttpStatus.FOUND.value());
		//			responseStructure.setMessage("Product Object Found Successfully!!");
		//			responseStructure.setData(product);
		//			
		//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);
		//		}else {
		//			 throw new ProductNotFoundByIdException("Product not present");
		//
		//		}

		//		*********   by using lambda expression ************

		return productRepository.findById(productId).map(product->ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value()).setMessage("Message found").setData(product))).orElseThrow(()->new ProductNotFoundByIdException("product not found By this particular Id"));

	}







	//	

	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updatedProduct) {
		Optional<Product> optional = productRepository.findById(productId);

		if(optional.isPresent()) {
			Product existingProduct = optional.get();
			updatedProduct.setProductId(existingProduct.getProductId());
			Product Product2 = productRepository.save(updatedProduct);

			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Data Updated Successfully!!");
			responseStructure.setData(Product2);

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {		

			throw new ProductNotFoundByIdException("Poduct Not Updated!!");
		}
	}






	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) {

		Optional<Product> optional = productRepository.findById(productId);

		if(optional.isPresent()) {
			Product product = optional.get();
			productRepository.delete(product);

			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Product Object Deleted Successfully!!");

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		}else {
			throw new ProductNotFoundByIdException("Product not by id ");
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		List<Product> all = productRepository.findAll();
		ResponseStructure responseStructure=new ResponseStructure();
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setMessage("All products found");
		responseStructure.setData(all);
		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.OK);
	}


}
