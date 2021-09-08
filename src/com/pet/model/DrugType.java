package com.pet.model;

import com.pet.model.Schedule.Day;

public class DrugType {
	private Integer drugId;
	private String drugName;
	private int drugDuration;
	public enum Type{year,month,day} ;
	private Type drugDurationType;
	
	public DrugType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DrugType(Integer drugId, String drugName, int drugDuration, Type drugDurationType) {
		super();
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugDuration = drugDuration;
		this.drugDurationType = drugDurationType;
	}
	@Override
	public String toString() {
		return "DrugType [drugId=" + drugId + ", drugName=" + drugName + ", drugDuration=" + drugDuration
				+ ", drugDurationType=" + drugDurationType + "]";
	}
	public Integer getDrugId() {
		return drugId;
	}
	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public int getDrugDuration() {
		return drugDuration;
	}
	public void setDrugDuration(int drugDuration) {
		this.drugDuration = drugDuration;
	}
	public Type getDrugDurationType() {
		return drugDurationType;
	}
	public void setDrugDurationType(Type drugDurationType) {
		this.drugDurationType = drugDurationType;
	}	
}
