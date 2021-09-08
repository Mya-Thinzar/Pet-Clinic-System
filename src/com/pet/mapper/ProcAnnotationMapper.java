package com.pet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import com.pet.model.DrugType;
import com.pet.model.ProcAppDate;
import com.pet.model.ProcLastInsertId;

public interface ProcAnnotationMapper {
	@Select(""+
		"{call procAppDate("+
			"#{curDate,mode=OUT,jdbcType=VARCHAR}"+
			")"+	
		"}"
	)
	@Options(statementType=StatementType.CALLABLE)
	public void procCall(ProcAppDate tm);

	@Select(""+
		"{call procSaveDrugType1("+
			"#{drugName,mode=IN,jdbcType=VARCHAR},"+
			"#{drugDuration,mode=IN,jdbcType=INTEGER},"+
			"#{drugDurationType,mode=IN,jdbcType=VARCHAR},"+
			"#{drugId,mode=OUT,jdbcType=INTEGER}"+
			")"+	
		"}"
	)
	@Options(statementType=StatementType.CALLABLE)
	public void procCall1(
			@Param("drugName") String name,
			@Param("drugDuration") int duration,
			@Param("drugDurationType") String type,
			ProcLastInsertId id);

	@Select(""+
			"{call procSaveDrugType1("+
			"#{drugName,mode=IN,jdbcType=VARCHAR},"+
			"#{drugDuration,mode=IN,jdbcType=INTEGER},"+
			"#{drugDurationType,mode=IN,jdbcType=VARCHAR},"+
			"#{drugId,mode=OUT,jdbcType=INTEGER}"+
			")"+	
		"}"
	)
	@Options(statementType=StatementType.CALLABLE)
	@Results(
			value={
			@Result(column="drug_id",property="lastId")				
			})
	public Integer procCallId();
}
