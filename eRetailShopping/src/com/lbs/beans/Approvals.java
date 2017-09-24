package com.lbs.beans;

import java.io.Serializable;

public class Approvals implements Serializable  {

	private String labId;
	public Approvals(String labId, String labName, String userId,
			String location) {
	
		this.labId = labId;
		this.labName = labName;
		this.userId = userId;
		this.location = location;
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	private String labName;
	private String userId;
	private String location ;
	public String getLabId() {
		return labId;
	}
	public void setLabId(String labId) {
		this.labId = labId;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Approvals(){
		
	}
	
}
