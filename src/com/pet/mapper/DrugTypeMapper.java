package com.pet.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pet.model.DrugType;
import com.pet.model.Schedule;
import com.pet.model.Species;

public interface DrugTypeMapper {
//	public void insertDrugType(DrugType dt);
	public void insertDrugType(DrugType dt);	
	//public void insertDrugType(@Param("returnedId") Integer returnedId, @Param("drugName")String drugName,@Param("drugDruation") int drugDuration,@Param("drugDurationType") String drugDurationType);

	public List<DrugType> getAll();

	@Select("select dt.* "
			+"from drug_type dt "
			+"where drug_id=#{drugId}")
	@Results({
			@Result(column="drug_id",property="drugId"),
			@Result(column="drug_name",property="drugName"),
			@Result(column="drug_duration",property="drugDuration"),
			@Result(column="drug_duration_type",property="drugDurationType")
	})
	public List<DrugType> getDrugById(int id);
}