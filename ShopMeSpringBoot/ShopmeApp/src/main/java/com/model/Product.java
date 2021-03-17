package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private double price;
	private String availability;
	private String imagePath;
	

	@OneToMany(mappedBy = "product")
	List<OrderDetails> orderdetails = new ArrayList<OrderDetails>(); // list of objects

	public Product() {
		super();
	}

	public Product(int productId, String productName, double price, String availability, String imagePath,
			List<OrderDetails> orderdetails) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.availability = availability;
		this.imagePath = imagePath;
		this.orderdetails = orderdetails;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<OrderDetails> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<OrderDetails> orderdetails) {
		this.orderdetails = orderdetails;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", availability=" + availability + ", imagePath=" + imagePath + ", orderdetails=" + orderdetails
				+ "]";
	}
	
	

}