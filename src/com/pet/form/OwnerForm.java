package com.pet.form;

import java.util.List;

import com.pet.model.Owner;

public class OwnerForm {
	private String frmId;
	private String frmName;
	private String frmPhone;
	private String frmEmail;
	private String frmAddress;
	
	private List<Owner> frmOwnerList;
	
	public List<Owner> getFrmOwnerList() {
		return frmOwnerList;
	}
	public void setFrmOwnerList(List<Owner> frmOwnerList) {
		this.frmOwnerList = frmOwnerList;
	}
	public OwnerForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OwnerForm(String frmId, String frmName, String frmPhone, String frmEmail, String frmAddress) {
		super();
		this.frmId = frmId;
		this.frmName = frmName;
		this.frmPhone = frmPhone;
		this.frmEmail = frmEmail;
		this.frmAddress = frmAddress;
	}
	public String getFrmId() {
		return frmId;
	}
	public void setFrmId(String frmId) {
		this.frmId = frmId;
	}
	public String getFrmName() {
		return frmName;
	}
	public void setFrmName(String frmName) {
		this.frmName = frmName;
	}
	public String getFrmPhone() {
		return frmPhone;
	}
	public void setFrmPhone(String frmPhone) {
		this.frmPhone = frmPhone;
	}
	public String getFrmEmail() {
		return frmEmail;
	}
	public void setFrmEmail(String frmEmail) {
		this.frmEmail = frmEmail;
	}
	public String getFrmAddress() {
		return frmAddress;
	}
	public void setFrmAddress(String frmAddress) {
		this.frmAddress = frmAddress;
	}
}
