package com.pet.mapper;
import java.util.List;

import com.pet.model.Species;

public interface SpeciesMapper {
	public void insertSpecies(Species s);
	public List<Species> getAll();
	public List<Species> getSpeciesById(String sId);
	public void updateSpecies(Species myS);
}