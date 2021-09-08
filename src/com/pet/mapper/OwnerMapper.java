package com.pet.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pet.model.Owner;

public interface OwnerMapper {
	public void insertOwner(Owner myOwner);
	public List<Owner> getAll();
	public List<Owner> getOwnerById(@Param("ownerId") String id);
	public void updateOwner(Owner myOwner);
}