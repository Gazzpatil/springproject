package com.jsp.springproject.product.productrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.springproject.product.productentity.Product;
//@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
