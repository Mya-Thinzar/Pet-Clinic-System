package com.pet.mapper;
import com.pet.model.PetUserLogin;

public interface AdminRegisterMapper {
	public void insertAdmin(PetUserLogin myAdmin);
	public void updateUser(PetUserLogin user);
}