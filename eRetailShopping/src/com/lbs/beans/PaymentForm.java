package com.lbs.beans;

public class PaymentForm {
	int customerId;
	String accountNo;
	int ccv;
	int month;
	int year;
	String nameOnCard;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getCcv() {
		return ccv;
	}
	public void setCcv(int ccv) {
		this.ccv = ccv;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public PaymentForm(){
		
	}
	
	public PaymentForm(int customerId,String accountNo,int ccv,String nameOnCard,int month, int year ){
		this.customerId = customerId;
		this.accountNo = accountNo;
		this.ccv = ccv;
		this.nameOnCard = nameOnCard;
		this.month = month;
		this.year = year;
	}

}
