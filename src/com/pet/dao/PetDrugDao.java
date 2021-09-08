package com.pet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.mapper.PetDrugMapper;
import com.pet.mapper.PetMapper;
import com.pet.model.Pet;
import com.pet.model.PetDrug;

public class PetDrugDao {
	private SqlSessionFactory sfactory;

	public PetDrugDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	
	public void savePetDrug(PetDrug p) {
		try {
			SqlSession s = this.sfactory.openSession();
			PetDrugMapper pm = s.getMapper(PetDrugMapper.class);
			pm.insertPetDrug(p);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<PetDrug> getPetHistory() {
		List<PetDrug> l = null;
		try {
			SqlSession s = this.sfactory.openSession();
			PetDrugMapper pm = s.getMapper(PetDrugMapper.class);
			l = pm.getPetHistory();
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;
	}


	public List<PetDrug> getDrugTime(String ownerId) {
		List<PetDrug> l = null;
		try {
			SqlSession s = this.sfactory.openSession();
			PetDrugMapper pm = s.getMapper(PetDrugMapper.class);
			l = pm.getDrugTime(ownerId);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;
	}


}
