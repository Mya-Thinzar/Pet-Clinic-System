package com.pet.form;

import java.util.List;

import com.pet.model.Appointment;
import com.pet.model.Owner;

public class AppointmentForm {
	private String frmAppId;
	private String frmAppDate;
	private String frmAppTime;
	
	private Owner frmOwner;
	private String frmOwnerId;
	
	List<Appointment> frmAppList;

	public String getFrmAppId() {
		return frmAppId;
	}

	public void setFrmAppId(String frmAppId) {
		this.frmAppId = frmAppId;
	}

	public String getFrmAppDate() {
		return frmAppDate;
	}

	public void setFrmAppDate(String frmAppDate) {
		this.frmAppDate = frmAppDate;
	}

	public String getFrmAppTime() {
		return frmAppTime;
	}

	public void setFrmAppTime(String frmAppTime) {
		this.frmAppTime = frmAppTime;
	}

	public Owner getFrmOwner() {
		return frmOwner;
	}

	public void setFrmOwner(Owner frmOwner) {
		this.frmOwner = frmOwner;
	}

	public String getFrmOwnerId() {
		return frmOwnerId;
	}

	public void setFrmOwnerId(String frmOwnerId) {
		this.frmOwnerId = frmOwnerId;
	}

	public List<Appointment> getFrmAppList() {
		return frmAppList;
	}

	public void setFrmAppList(List<Appointment> frmAppList) {
		this.frmAppList = frmAppList;
	}
	
}
