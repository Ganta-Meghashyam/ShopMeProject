package com.ts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CustomerDao;
import com.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	CustomerDao customerdao;

	@RequestMapping("/registerCustomer")
	public void register() {
		Customer c1 = new Customer();
		c1.setCustomerName("sandeep");
		c1.setEmailId("sandeep.chitturi6667@gmail.com");
		c1.setPhoneNumber(8106962667l);
		c1.setBillingAddress("rjy");
		c1.setShippingAddress("rjy");
		c1.setUserName("sandy123");
		c1.setPassword("password");

		customerdao.register(c1);
	}

	@RequestMapping("/showAllCustomers")
	public List<Customer> showAllCustomers() {
		List<Customer> customerList = customerdao.getCustomer();
		return customerList;
	}

	@GetMapping("/getCustomer/{userName}/{password}")
	public Customer getCustomer(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		System.out.print("asdf");
		return customerdao.getCustomer(userName, password);
	}
	
	@PostMapping("/registerCustomer")
	public void registerCustomer(@RequestBody Customer customer) {
		System.out.println("Data Received from Angular for Register Customer");
		System.out.println(customer);
		
		customerdao.register(customer);
		
	}
	
	@PostMapping("/updateCustomer")
	public void updateEmp(@RequestBody Customer customer) {
		customerdao.updateCustomer(customer);
	}

}
