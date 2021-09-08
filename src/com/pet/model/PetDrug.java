package com.pet.model;

import java.util.Date;

public class PetDrug {
	private Integer id;
	private Date drugDate;
	private Date drugNextDate;
	private String drugDesc;
	
	private Pet pet;
	private String petId;
	
	private DrugType drugType;
	private Integer drugId;
	
	private Doctor doctor;
	private String doctorId;
	
	//only show
	private Owner owner;
	private String ownerId;
	
	public PetDrug() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PetDrug(Integer id, Date drugDate, Date drugNextDate, String drugDesc, Pet pet, String petId,
			DrugType drugType, Integer drugId, Doctor doctor, String doctorId, Owner owner, String ownerId) {
		super();
		this.id = id;
		this.drugDate = drugDate;
		this.drugNextDate = drugNextDate;
		this.drugDesc = drugDesc;
		this.pet = pet;
		this.petId = petId;
		this.drugType = drugType;
		this.drugId = drugId;
		this.doctor = doctor;
		this.doctorId = doctorId;
		this.owner = owner;
		this.ownerId = ownerId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDrugDate() {
		return drugDate;
	}
	public void setDrugDate(Date drugDate) {
		this.drugDate = drugDate;
	}
	public Date getDrugNextDate() {
		return drugNextDate;
	}
	public void setDrugNextDate(Date drugNextDate) {
		this.drugNextDate = drugNextDate;
	}
	public String getDrugDesc() {
		return drugDesc;
	}
	public void setDrugDesc(String drugDesc) {
		this.drugDesc = drugDesc;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public String getPetId() {
		return petId;
	}
	public void setPetId(String petId) {
		this.petId = petId;
	}
	public DrugType getDrugType() {
		return drugType;
	}
	public void setDrugType(DrugType drugType) {
		this.drugType = drugType;
	}
	public Integer getDrugId() {
		return drugId;
	}
	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
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
