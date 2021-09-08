package com.pet.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pet.model.Pet;
import com.pet.model.PetDrug;

public interface PetDrugMapper {
	public void insertPetDrug(PetDrug myPetDrug);

	@Select("select p.*,d.*,pd.*,dt.* "
			+"from pet p,doctor d,pet_drug pd,drug_type dt "
			+"where pd.doctor_id=d.doctor_id "
			+"and pd.drug_id=dt.drug_id "
			+"and pd.pet_id=p.pet_id "
			+"order by pd.pet_id")
	@Results({
			@Result(column="id",property="id"),
			@Result(column="drug_date",property="drugDate"),
			@Result(column="drug_next_date",property="drugNextDate"),
			@Result(column="drug_desc",property="drugDesc"),	
			@Result(column="pet_id",property="petId"),
			@Result(column="drug_id",property="drugId"),
			@Result(column="doctor_id",property="doctorId"),
			@Result(column="pet_id",property="pet.petId"),
			@Result(column="pet_name",property="pet.petName"),
			@Result(column="pet_sex",property="pet.petSex"),
			@Result(column="pet_birth",property="pet.petBirth"),
			@Result(column="pet_death",property="pet.petDeath"),
			@Result(column="species_id",property="pet.speciesId"),
			@Result(column="owner_id",property="pet.ownerId"),
			@Result(column="drug_id",property="drugType.drugId"),
			@Result(column="drug_name",property="drugType.drugName"),
			@Result(column="drug_duration",property="drugType.drugDuration"),
			@Result(column="drug_duration_type",property="drugType.drugDurationType"),
			@Result(column="doctor_id",property="doctor.doctorId"),
			@Result(column="doctor_name",property="doctor.doctorName"),
			@Result(column="doctor_rank",property="doctor.doctorRank")
	})
	public List<PetDrug> getPetHistory();

	@Select("select pd.*,p.*,o.*,d.* "
			+"from owner o,pet_drug pd,pet p,doctor d "
			+"where pd.pet_id=p.pet_id "
            +"and p.owner_id=o.owner_id "
            +"and pd.doctor_id=d.doctor_id "
            +"and o.owner_id=#{ownerId} "
            +"order by pd.pet_id")
	@Results({
			@Result(column="id",property="id"),
			@Result(column="drug_date",property="drugDate"),
			@Result(column="drug_next_date",property="drugNextDate"),
			@Result(column="drug_desc",property="drugDesc"),	
			@Result(column="pet_id",property="petId"),
			@Result(column="drug_id",property="drugId"),
			@Result(column="doctor_id",property="doctorId"),
			@Result(column="pet_id",property="pet.petId"),
			@Result(column="pet_name",property="pet.petName"),
			@Result(column="pet_sex",property="pet.petSex"),
			@Result(column="pet_birth",property="pet.petBirth"),
			@Result(column="pet_death",property="pet.petDeath"),
			@Result(column="species_id",property="pet.speciesId"),
			@Result(column="owner_id",property="pet.ownerId"),
			@Result(column="owner_id",property="owner.ownerId"),
			@Result(column="owner_name",property="owner.ownerName"),
			@Result(column="owner_ph",property="owner.ownerPh"),
			@Result(column="owner_email",property="owner.ownerEmail"),
			@Result(column="owner_add",property="owner.ownerAdd"),
			@Result(column="doctor_id",property="doctor.doctorId"),
			@Result(column="doctor_name",property="doctor.doctorName"),
			@Result(column="doctor_rank",property="doctor.doctorRank")
	})
	public List<PetDrug> getDrugTime(String ownerId);
}