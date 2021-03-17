package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private double amount;
	private Date orderDate;

	@ManyToOne
	@JoinColumn(name = "customer_Id")
	Customer customer; // only 1 object

	@OneToMany(mappedBy = "orders")
	List<OrderDetails> orderdetails = new ArrayList<OrderDetails>(); // list of objects

	public Orders() {
		super();
	}

	public Orders(int orderId, double amount, Date orderDate, Customer customer, List<OrderDetails> orderdetails) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderdetails = orderdetails;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetails> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<OrderDetails> orderdetails) {
		this.orderdetails = orderdetails;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", amount=" + amount + ", orderDate=" + orderDate + ", customer="
				+ customer + ", orderdetails=" + orderdetails + "]";
	}

	

}
