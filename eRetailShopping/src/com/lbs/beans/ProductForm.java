package com.lbs.beans;

public class ProductForm {
	
	int productId;
	String productName;
	int categoryId;
	double price;
	
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public ProductForm(){
		
	}
	
	public ProductForm(int productId, String productName, int categoryId, double price){
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.price = price;
		
	}
	

}
