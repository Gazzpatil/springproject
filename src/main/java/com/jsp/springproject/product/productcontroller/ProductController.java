package com.jsp.springproject.product.productcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.springproject.product.productentity.Product;
import com.jsp.springproject.product.productservice.ProductService;
import com.jsp.springproject.product.utility.ResponseStructure;

import java.util.List;

//@Controller
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	
	@PostMapping("/Product/addProduct")
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product) {
		System.out.println("product price in controller :" +product.getProductPrice());
		return productService.addProduct(product);
		}
	
	@GetMapping("/Product/findByProductId/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findByIdProduct(@PathVariable int productId) {
		return productService.findByProductId(productId);
	}
	
	@PutMapping("/product/updateByProductId/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(@PathVariable int productId, @RequestBody Product updatedProduct) {
		return productService.updateByProductId(productId, updatedProduct);
		
	}
	
	@DeleteMapping("product/deleteByProductId/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(@PathVariable int productId) {
		return productService.deleteByProductId(productId);
		
	}
	
	@GetMapping("product/getAllProducts")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllByProductId() {
		ResponseEntity<ResponseStructure<List<Product>>> allProducts = productService.findAllProducts();
		return allProducts;
	}

}
