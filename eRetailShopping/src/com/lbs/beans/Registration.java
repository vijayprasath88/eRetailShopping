package com.lbs.beans;

import java.io.Serializable;

public class Registration implements Serializable {
 String email ;
	public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
	public Registration(String email, String password) {
		
		this.email = email;
		this.password = password;
	}
	private String password ;
		public Registration(){
		
	}
	
	
}
