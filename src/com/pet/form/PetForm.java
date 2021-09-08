package com.pet.form;

import java.util.Date;
import java.util.List;

import com.pet.model.Owner;
import com.pet.model.Pet;
import com.pet.model.Species;

public class PetForm {
	private String frmId;
	private String frmName;
	private String frmSex;
	private Date frmBirthDate;
	private Date frmDeathDate;
	
	private String frmOwnerId;
	private Owner frmOwner; 
	
	private Integer frmSpeciesId;
	private Species frmSpecies;
	
	private List<Pet> frmPetList;
	private List<Species> frmSpeciesList;
	public List<Species> getFrmSpeciesList() {
		return frmSpeciesList;
	}

	public void setFrmSpeciesList(List<Species> frmSpeciesList) {
		this.frmSpeciesList = frmSpeciesList;
	}

	public PetForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetForm(String frmId, String frmName, String frmSex, Date frmBirthDate, Date frmDeathDate, String frmOwnerId,
			Owner frmOwner, Integer frmSpeciesId, Species frmSpecies, List<Pet> frmPetList) {
		super();
		this.frmId = frmId;
		this.frmName = frmName;
		this.frmSex = frmSex;
		this.frmBirthDate = frmBirthDate;
		this.frmDeathDate = frmDeathDate;
		this.frmOwnerId = frmOwnerId;
		this.frmOwner = frmOwner;
		this.frmSpeciesId = frmSpeciesId;
		this.frmSpecies = frmSpecies;
		this.frmPetList = frmPetList;
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

	public String getFrmSex() {
		return frmSex;
	}

	public void setFrmSex(String frmSex) {
		this.frmSex = frmSex;
	}

	public Date getFrmBirthDate() {
		return frmBirthDate;
	}

	public void setFrmBirthDate(Date frmBirthDate) {
		this.frmBirthDate = frmBirthDate;
	}

	public Date getFrmDeathDate() {
		return frmDeathDate;
	}

	public void setFrmDeathDate(Date frmDeathDate) {
		this.frmDeathDate = frmDeathDate;
	}

	public String getFrmOwnerId() {
		return frmOwnerId;
	}

	public void setFrmOwnerId(String frmOwnerId) {
		this.frmOwnerId = frmOwnerId;
	}

	public Owner getFrmOwner() {
		return frmOwner;
	}

	public void setFrmOwner(Owner frmOwner) {
		this.frmOwner = frmOwner;
	}

	public Integer getFrmSpeciesId() {
		return frmSpeciesId;
	}

	public void setFrmSpeciesId(Integer frmSpeciesId) {
		this.frmSpeciesId = frmSpeciesId;
	}

	public Species getFrmSpecies() {
		return frmSpecies;
	}

	public void setFrmSpecies(Species frmSpecies) {
		this.frmSpecies = frmSpecies;
	}

	public List<Pet> getFrmPetList() {
		return frmPetList;
	}

	public void setFrmPetList(List<Pet> frmPetList) {
		this.frmPetList = frmPetList;
	}

}
