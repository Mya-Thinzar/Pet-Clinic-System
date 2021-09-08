package com.pet.model;
import java.util.Date;


public class Appointment {
	private Integer appId;
	private Date appDate;
	private String appTime;
	
	private Owner owner;
	private String ownerId;
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(Integer appId, Date appDate, String appTime, Owner owner, String ownerId) {
		super();
		this.appId = appId;
		this.appDate = appDate;
		this.appTime = appTime;
		this.owner = owner;
		this.ownerId = ownerId;
	}
	public Integer getappId() {
		return appId;
	}
	public void setappId(Integer appId) {
		this.appId = appId;
	}
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	public String getAppTime() {
		return appTime;
	}
	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
}
