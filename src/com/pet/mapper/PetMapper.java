package com.pet.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pet.model.Pet;

public interface PetMapper {
	public void insertPet(Pet myPet);
	
	@Select("select p.* "
			+"from pet p "
			+"where p.owner_id=#{ownerId} "
			+"and p.species_id=#{speciesId} "
			+"and p.pet_id=#{petId}")
	@Results({
			@Result(column="pet_id",property="petId"),
			@Result(column="pet_name",property="petName"),
			@Result(column="pet_sex",property="petSex"),
			@Result(column="pet_birth",property="petBirth"),	
			@Result(column="pet_death",property="petDeath"),
			@Result(column="species_id",property="speciesId"),
			@Result(column="owner_id",property="ownerId")
	})
	public List<Pet> getPetById(@Param("ownerId") String oId,@Param("speciesId") Integer sId,@Param("petId") String pId);
	
	@Select("select o.*,s.*,p.* "
			+ "from owner o,species s,pet p "
			+ "where o.owner_id=#{ownerId} "
			+ "and p.owner_id=o.owner_id "
			+ "and p.species_id=s.species_id")
	@Results({
			@Result(column="pet_id",property="petId"),
			@Result(column="pet_name",property="petName"),
			@Result(column="pet_sex",property="petSex"),
			@Result(column="pet_birth",property="petBirth"),	
			@Result(column="pet_death",property="petDeath"),
			@Result(column="species_id",property="speciesId"),
			@Result(column="owner_id",property="ownerId"),
			@Result(column="owner_id",property="owner.ownerId"),
			@Result(column="owner_name",property="owner.ownerName"),
			@Result(column="owner_ph",property="owner.ownerPh"),
			@Result(column="owner_email",property="owner.ownerEmail"),
			@Result(column="owner_add",property="owner.ownerAdd"),
			@Result(column="species_id",property="species.speciesId"),
			@Result(column="species_name",property="species.speciesName")
	})
	public List<Pet> getAllPetsByOwnerIdAndSpeciesId(String oId);
	
	@Select("select p.*,o.*,s.* "
			+"from pet p,owner o,species s "
			+"where (p.pet_death is NULL) "
			+"and p.owner_id=o.owner_id "
			+"and p.species_id=s.species_id")
	@Results({
			@Result(column="pet_id",property="petId"),
			@Result(column="pet_name",property="petName"),
			@Result(column="pet_sex",property="petSex"),
			@Result(column="pet_birth",property="petBirth"),	
			@Result(column="pet_death",property="petDeath"),
			@Result(column="species_id",property="speciesId"),
			@Result(column="owner_id",property="ownerId"),
			@Result(column="owner_id",property="owner.ownerId"),
			@Result(column="owner_name",property="owner.ownerName"),
			@Result(column="owner_ph",property="owner.ownerPh"),
			@Result(column="owner_email",property="owner.ownerEmail"),
			@Result(column="owner_add",property="owner.ownerAdd"),
			@Result(column="species_id",property="species.speciesId"),
			@Result(column="species_name",property="species.speciesName")
	})
	public List<Pet> getAllPetsForTreatment();
	
	public void updatePet(Pet myP);

	@Select("select p.*,o.*,s.*,a.* "
			+"from pet p,owner o,species s,appointment a "
			+"where (p.pet_death is NULL) "
			+"and p.owner_id=o.owner_id "
			+"and o.owner_id=a.owner_id "
			+"and p.species_id=s.species_id "
			+"and p.pet_id=#{petId}")
	@Results({
			@Result(column="pet_id",property="petId"),
			@Result(column="pet_name",property="petName"),
			@Result(column="pet_sex",property="petSex"),
			@Result(column="pet_birth",property="petBirth"),	
			@Result(column="pet_death",property="petDeath"),
			@Result(column="species_id",property="speciesId"),
			@Result(column="owner_id",property="ownerId"),
			@Result(column="owner_id",property="owner.ownerId"),
			@Result(column="owner_name",property="owner.ownerName"),
			@Result(column="owner_ph",property="owner.ownerPh"),
			@Result(column="owner_email",property="owner.ownerEmail"),
			@Result(column="owner_add",property="owner.ownerAdd"),
			@Result(column="species_id",property="species.speciesId"),
			@Result(column="species_name",property="species.speciesName"),
			@Result(column="app_id",property="appointment.appId"),
			@Result(column="app_date",property="appointment.appDate"),
			@Result(column="app_time",property="appointment.appTime"),
			@Result(column="owner_id",property="ownerId")	
	})
	public List<Pet> getPetByPetId(String frmPetId);
	
	
}