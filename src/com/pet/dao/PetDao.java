package com.pet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.mapper.OwnerMapper;
import com.pet.mapper.PetMapper;
import com.pet.model.Pet;

public class PetDao {
	private SqlSessionFactory sfactory;

	public PetDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}
	
	public void updatePet(Pet myP){
		try {
			SqlSession s = this.sfactory.openSession();
			PetMapper pm = s.getMapper(PetMapper.class);
			pm.updatePet(myP);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Pet> getPetById(String oId,Integer sId,String pId) {
		List<Pet> l = null;
		try {
			System.out.println("Pet Dao Trace:" + oId + "," + sId+","+pId);
			SqlSession s = this.sfactory.openSession();
			PetMapper pm = s.getMapper(PetMapper.class);
			l = pm.getPetById(oId, sId, pId);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;
	}
	
	public void savePet(Pet p) {
		try {
			SqlSession s = this.sfactory.openSession();
			PetMapper pm = s.getMapper(PetMapper.class);
			pm.insertPet(p);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Pet> getAllPetsByOwnerIdAndSpeciesId(String oId) {
		List<Pet> l = null;
		try {
			SqlSession s = this.sfactory.openSession();
			PetMapper pm = s.getMapper(PetMapper.class);
			l = pm.getAllPetsByOwnerIdAndSpeciesId(oId);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;
	}

	public List<Pet> getAllPetsForTreatment() {
		List<Pet> l = null;
		try {
			SqlSession s = this.sfactory.openSession();
			PetMapper pm = s.getMapper(PetMapper.class);
			l = pm.getAllPetsForTreatment();
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;
	}

	public List<Pet> getPetbyPetId(String frmPetId) {
		List<Pet> l = null;
		try {
			SqlSession s = this.sfactory.openSession();
			PetMapper pm = s.getMapper(PetMapper.class);
			l = pm.getPetByPetId(frmPetId);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;
	}
}
