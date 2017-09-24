package com.lbs.beans;

public class OrderPlacedForm {
	int orderId;
	int customerId;
	int productId;
	String orderDate;
	double orderAmount;
	String orderConfirmed;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderConfirmed() {
		return orderConfirmed;
	}
	public void setOrderConfirmed(String orderConfirmed) {
		this.orderConfirmed = orderConfirmed;
	}
	
	public OrderPlacedForm(){
		
	}

}
