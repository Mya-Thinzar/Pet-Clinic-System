package com.pet.mapper;
import org.apache.ibatis.annotations.Param;

import com.pet.model.PetUserLogin;

public interface UserLoginMapper {
	public PetUserLogin getUser(@Param("loginId") String id,
			@Param("loginPassword") String password);
}