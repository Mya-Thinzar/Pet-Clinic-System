package com.pet.model;

import java.util.List;

public class Owner {
	private String ownerId;
	private String ownerName;
	private String ownerPh;
	private String ownerEmail;
	private String ownerAdd;
	
	private List<Pet> ownerPets;
	private List<Owner> ownerList;
	
	private List<Appointment> ownerApps;
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Owner(String ownerId, String ownerName, String ownerPh, String ownerEmail, String ownerAdd,
			List<Pet> ownerPets, List<Owner> ownerList, List<Appointment> ownerApps) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerPh = ownerPh;
		this.ownerEmail = ownerEmail;
		this.ownerAdd = ownerAdd;
		this.ownerPets = ownerPets;
		this.ownerList = ownerList;
		this.ownerApps = ownerApps;
	}
	public List<Appointment> getOwnerApps() {
		return ownerApps;
	}
	public void setOwnerApps(List<Appointment> ownerApps) {
		this.ownerApps = ownerApps;
	}
	public List<Pet> getOwnerPets() {
		return ownerPets;
	}
	public void setOwnerPets(List<Pet> ownerPets) {
		this.ownerPets = ownerPets;
	}
	public List<Owner> getOwnerList() {
		return ownerList;
	}
	public void setOwnerList(List<Owner> ownerList) {
		this.ownerList = ownerList;
	}

	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerPh() {
		return ownerPh;
	}
	public void setOwnerPh(String ownerPh) {
		this.ownerPh = ownerPh;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getOwnerAdd() {
		return ownerAdd;
	}
	public void setOwnerAdd(String ownerAdd) {
		this.ownerAdd = ownerAdd;
	}

}
