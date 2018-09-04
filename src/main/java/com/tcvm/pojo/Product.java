package com.tcvm.pojo;

public class Product {

	private String productName;
	private Integer quantity;
	private Integer price;

	public Product(String productName, Integer quantity, Integer price) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public Integer getPrice() {
		return price;
	}

	

}