package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Orders;

@Service
public class OrdersDao {

	@Autowired
	OrdersRepository ordersrepository;

	public void register(Orders o1) {
		ordersrepository.save(o1);
	}

	public List<Orders> getOrders() {
		return ordersrepository.findAll();
	}
}
