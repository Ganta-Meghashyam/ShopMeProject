package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;

@Service
public class ProductDao {

	@Autowired
	ProductRepository productrepository;

	public void register(Product p1) {
		productrepository.save(p1);
	}

	public List<Product> getProduct() {
		return productrepository.findAll();
	}
}
