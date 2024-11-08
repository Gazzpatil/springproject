package com.jsp.springproject.product;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsp.springproject.product.productentity.Product;

@SpringBootApplication
public class SpringprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
		System.out.println("Hello World");
		System.out.println("Beans got created Successfully");
		Product product=new Product();
//		Optional.of(product).map(p->{System.out.println("inside map");
//		return p;}).orElseThrow(()->new RunTimeException());
		
	}

}
