package com.pet.model;

import java.util.Date;

public class Pet {
	private String petId;
	private String petName;
	private String petSex;
	private Date petBirth;
	private Date petDeath;
	
	private Owner owner;
	private String ownerId;
	
	private Species species;
	private Integer speciesId;
	
	private Appointment appointment;
	private Integer appId;

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pet(String petId, String petName, String petSex, Date petBirth, Date petDeath, Owner owner, String ownerId,
			Species species, Integer speciesId, Appointment appointment, Integer appId) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petSex = petSex;
		this.petBirth = petBirth;
		this.petDeath = petDeath;
		this.owner = owner;
		this.ownerId = ownerId;
		this.species = species;
		this.speciesId = speciesId;
		this.appointment = appointment;
		this.appId = appId;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public Integer getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
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

	public String getPetId() {
		return petId;
	}
	public void setPetId(String petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetSex() {
		return petSex;
	}
	public void setPetSex(String petSex) {
		this.petSex = petSex;
	}
	public Date getPetBirth() {
		return petBirth;
	}
	public void setPetBirth(Date petBirth) {
		this.petBirth = petBirth;
	}
	public Date getPetDeath() {
		return petDeath;
	}
	public void setPetDeath(Date petDeath) {
		this.petDeath = petDeath;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
}
