package com.lbs.beans;

public class Login {
	private String email;
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		
	}
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setemail(String userId) {
		this.email = userId;
	}
        public String getemail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Login [userId=" + email + ", password=" + password + "]";
	}
	public Login(){
		
	}
	
}
