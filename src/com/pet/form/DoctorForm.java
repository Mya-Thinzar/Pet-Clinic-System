package com.pet.form;

import java.util.List;

import com.pet.model.Doctor;

public class DoctorForm {
	private String frmId;
	private String frmName;
	private String frmRank;
	private List<Doctor> frmDoctorList;
	public DoctorForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorForm(String frmId, String frmName, String frmRank) {
		super();
		this.frmId = frmId;
		this.frmName = frmName;
		this.frmRank = frmRank;
	}
	public List<Doctor> getFrmDoctorList() {
		return frmDoctorList;
	}
	public void setFrmDoctorList(List<Doctor> frmDoctorList) {
		this.frmDoctorList = frmDoctorList;
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
	public String getFrmRank() {
		return frmRank;
	}
	public void setFrmRank(String frmRank) {
		this.frmRank = frmRank;
	}
}
