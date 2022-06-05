package com.algoDomain.TechnicalTask.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private String type;
	private String category;
	private String productPrice;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", type=" + type + ", category="
				+ category + ", productPrice=" + productPrice + "]";
	}
	public Product(int productId, String productName, String type, String category, String productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.type = type;
		this.category = category;
		this.productPrice = productPrice;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
