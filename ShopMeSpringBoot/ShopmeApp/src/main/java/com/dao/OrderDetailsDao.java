package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.OrderDetails;

@Service
public class OrderDetailsDao {

	@Autowired
	OrderDetailsRepository orderdetailsrepository;

	public void register(OrderDetails od1) {
		orderdetailsrepository .save(od1);
	}

	public List<OrderDetails> getOrderDetails() {
		return orderdetailsrepository.findAll();
	}
}
