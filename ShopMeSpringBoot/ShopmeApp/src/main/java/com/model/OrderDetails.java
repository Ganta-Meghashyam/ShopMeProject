package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailsId;
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "product_Id") 
	Product product; // only 1 object

	@ManyToOne
	@JoinColumn(name = "order_Id") 
	Orders orders; // only 1 object

	public OrderDetails() {
		super();
	}

	public OrderDetails(int orderDetailsId, int quantity, Product product, Orders orders) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.quantity = quantity;
		this.product = product;
		this.orders = orders;
	}

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "orderDetails [orderDetailsId=" + orderDetailsId + ", quantity=" + quantity +  ", product=" + product + ", orders=" + orders + "]";
	}
}
