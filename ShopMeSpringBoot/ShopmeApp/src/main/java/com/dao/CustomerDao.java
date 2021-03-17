package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Customer;

@Service
public class CustomerDao {

	@Autowired
	CustomerRepository customerrepository;

	public void register(Customer c1) {
		customerrepository.save(c1);
	}

	public List<Customer> getCustomer() {
		return customerrepository.findAll();
	}

	public Customer getCustomer(String userName, String password) {
		return customerrepository.findByuserNameAndPassword(userName, password);
	}

	public void updateCustomer(Customer customer) {
		customerrepository.save(customer);
	}


}
