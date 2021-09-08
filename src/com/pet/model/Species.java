package com.pet.model;

import java.util.List;

public class Species {
	private Integer speciesId;
	private String speciesName;
	
	private List<Pet> speciesPets;
	private List<Species> speciesList;
	
	public Species() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Species(Integer speciesId, String speciesName, List<Pet> speciesPets, List<Species> speciesList) {
		super();
		this.speciesId = speciesId;
		this.speciesName = speciesName;
		this.speciesPets = speciesPets;
		this.speciesList = speciesList;
	}
	public Integer getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}
	public String getSpeciesName() {
		return speciesName;
	}
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
	public List<Pet> getSpeciesPets() {
		return speciesPets;
	}
	public void setSpeciesPets(List<Pet> speciesPets) {
		this.speciesPets = speciesPets;
	}
	public List<Species> getSpeciesList() {
		return speciesList;
	}
	public void setSpeciesList(List<Species> speciesList) {
		this.speciesList = speciesList;
	}
}
