package com.pet.form;

import java.util.List;

import com.pet.model.Species;

public class SpeciesForm {
	private String frmName;
	private String frmSpeciesId;
	
	private String frmOwnerId;
	private List<Species> frmSpeciesList;
	

	public SpeciesForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpeciesForm(String frmName, String frmSpeciesId, String frmOwnerId, List<Species> frmSpeciesList) {
		super();
		this.frmName = frmName;
		this.frmSpeciesId = frmSpeciesId;
		this.frmOwnerId = frmOwnerId;
		this.frmSpeciesList = frmSpeciesList;
	}

	public String getFrmSpeciesId() {
		return frmSpeciesId;
	}

	public void setFrmSpeciesId(String frmSpeciesId) {
		this.frmSpeciesId = frmSpeciesId;
	}

	public String getFrmOwnerId() {
		return frmOwnerId;
	}

	public List<Species> getFrmSpeciesList() {
		return frmSpeciesList;
	}

	public void setFrmSpeciesList(List<Species> frmSpeciesList) {
		this.frmSpeciesList = frmSpeciesList;
	}

	public void setFrmOwnerId(String frmOwnerId) {
		this.frmOwnerId = frmOwnerId;
	}
	
	public String getFrmName() {
		return frmName;
	}

	public void setFrmName(String frmName) {
		this.frmName = frmName;
	}
}
