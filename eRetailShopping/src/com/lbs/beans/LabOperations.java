package com.lbs.beans;

public class LabOperations {
    
	private String labCapacity ;
    private String dateOfRelease;
	private String dateOfRequest;
	private String labId; 
	private String userId;
	private String labLocation ;
	private String labStatus;
	public String getTypeOfRequest() {
		return typeOfRequest;
	}
	public void setTypeOfRequest(String typeOfRequest) {
		this.typeOfRequest = typeOfRequest;
	}
	private String typeOfRequest;
	public LabOperations(String labCapacity, String dateOfRelease,
			String dateOfRequest, String labId, String userId,
			String labLocation, String labStatus) {
		
		this.labCapacity = labCapacity;
		this.dateOfRelease = dateOfRelease;
		this.dateOfRequest = dateOfRequest;
		this.labId = labId;
		this.userId = userId;
		this.labLocation = labLocation;
		this.labStatus = labStatus;
	}
	public LabOperations(){
		
	}
	public String getLabStatus() {
		return labStatus;
	}
	public void setLabStatus(String labStatus) {
		this.labStatus = labStatus;
	}
	public String getLabCapacity() {
		return labCapacity;
	}
	public void setLabCapacity(String labCapacity) {
		this.labCapacity = labCapacity;
	}
	public String getDateOfRelease() {
		return dateOfRelease;
	}
	public void setDateOfRelease(String dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}
	public String getDateOfRequest() {
		return dateOfRequest;
	}
	public void setDateOfRequest(String dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	public String getLabId() {
		return labId;
	}
	public void setLabId(String labId2) {
		this.labId = labId2;
	}
	public String getLabLocation() {
		return labLocation;
	}
	public void setLabLocation(String labLocation) {
		this.labLocation = labLocation;
	}
	public String getUserId() {
		return userId;
	}
	public void setuserId(String UserId) {
		this.userId = UserId;
}
}
		