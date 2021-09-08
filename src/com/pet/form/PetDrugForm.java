package com.pet.form;

import java.util.Date;
import java.util.List;

import com.pet.model.Doctor;
import com.pet.model.DrugType;
import com.pet.model.Owner;
import com.pet.model.Pet;
import com.pet.model.PetDrug;
import com.pet.model.Species;

public class PetDrugForm {
	private Integer frmId;
	private Date frmDrugDate;
	private Date frmDrugNextDate;
	private String frmDrugDesc;
	
	private Pet frmPet;
	private String frmPetId;
	
	private DrugType frmDrugType;
	private Integer frmDrugId;
	
	private Doctor frmDoctor;
	private String frmDoctorId;
	
	private List<Pet> frmPetList;
	private List<DrugType> frmDrugTypeList;
	private List<PetDrug> frmPetDrugList;
	private List<Owner> frmOwner;
	private String frmOwnerId;
	public Integer getFrmId() {
		return frmId;
	}
	public void setFrmId(Integer frmId) {
		this.frmId = frmId;
	}
	public Date getFrmDrugDate() {
		return frmDrugDate;
	}
	public void setFrmDrugDate(Date frmDrugDate) {
		this.frmDrugDate = frmDrugDate;
	}
	public Date getFrmDrugNextDate() {
		return frmDrugNextDate;
	}
	public void setFrmDrugNextDate(Date frmDrugNextDate) {
		this.frmDrugNextDate = frmDrugNextDate;
	}
	public String getFrmDrugDesc() {
		return frmDrugDesc;
	}
	public void setFrmDrugDesc(String frmDrugDesc) {
		this.frmDrugDesc = frmDrugDesc;
	}
	public Pet getFrmPet() {
		return frmPet;
	}
	public void setFrmPet(Pet frmPet) {
		this.frmPet = frmPet;
	}
	public String getFrmPetId() {
		return frmPetId;
	}
	public void setFrmPetId(String frmPetId) {
		this.frmPetId = frmPetId;
	}
	public DrugType getFrmDrugType() {
		return frmDrugType;
	}
	public void setFrmDrugType(DrugType frmDrugType) {
		this.frmDrugType = frmDrugType;
	}
	public Integer getFrmDrugId() {
		return frmDrugId;
	}
	public void setFrmDrugId(Integer frmDrugId) {
		this.frmDrugId = frmDrugId;
	}
	public Doctor getFrmDoctor() {
		return frmDoctor;
	}
	public void setFrmDoctor(Doctor frmDoctor) {
		this.frmDoctor = frmDoctor;
	}
	public String getFrmDoctorId() {
		return frmDoctorId;
	}
	public void setFrmDoctorId(String frmDoctorId) {
		this.frmDoctorId = frmDoctorId;
	}
	public List<Pet> getFrmPetList() {
		return frmPetList;
	}
	public void setFrmPetList(List<Pet> frmPetList) {
		this.frmPetList = frmPetList;
	}
	public List<DrugType> getFrmDrugTypeList() {
		return frmDrugTypeList;
	}
	public void setFrmDrugTypeList(List<DrugType> frmDrugTypeList) {
		this.frmDrugTypeList = frmDrugTypeList;
	}
	public List<PetDrug> getFrmPetDrugList() {
		return frmPetDrugList;
	}
	public void setFrmPetDrugList(List<PetDrug> frmPetDrugList) {
		this.frmPetDrugList = frmPetDrugList;
	}
	public List<Owner> getFrmOwner() {
		return frmOwner;
	}
	public void setFrmOwner(List<Owner> frmOwner) {
		this.frmOwner = frmOwner;
	}
	public String getFrmOwnerId() {
		return frmOwnerId;
	}
	public void setFrmOwnerId(String frmOwnerId) {
		this.frmOwnerId = frmOwnerId;
	}

}
