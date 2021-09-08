package com.pet.form;

import java.util.List;

import com.pet.model.DrugType;

public class DrugTypeForm {
	private Integer frmDrugId;
	private String frmDrugName;
	private String frmDrugDuration;
	private String frmDrugDurationType;
	
	private List<DrugType> frmDrugTypeList;
	
	public Integer getFrmDrugId() {
		return frmDrugId;
	}
	public void setFrmDrugId(Integer frmDrugId) {
		this.frmDrugId = frmDrugId;
	}
	public String getFrmDrugName() {
		return frmDrugName;
	}
	public void setFrmDrugName(String frmDrugName) {
		this.frmDrugName = frmDrugName;
	}
	public String getFrmDrugDuration() {
		return frmDrugDuration;
	}
	public void setFrmDrugDuration(String frmDrugDuration) {
		this.frmDrugDuration = frmDrugDuration;
	}
	public String getFrmDrugDurationType() {
		return frmDrugDurationType;
	}
	public void setFrmDrugDurationType(String frmDrugDurationType) {
		this.frmDrugDurationType = frmDrugDurationType;
	}
	public List<DrugType> getFrmDrugTypeList() {
		return frmDrugTypeList;
	}
	public void setFrmDrugTypeList(List<DrugType> frmDrugTypeList) {
		this.frmDrugTypeList = frmDrugTypeList;
	}
	
}
