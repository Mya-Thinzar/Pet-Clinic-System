package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.pet.mapper.DrugTypeMapper;
import com.pet.mapper.OwnerMapper;
import com.pet.mapper.PetMapper;
import com.pet.mapper.ProcAnnotationMapper;
import com.pet.mapper.ScheduleMapper;
import com.pet.mapper.SpeciesMapper;
import com.pet.model.DrugType;
import com.pet.model.Owner;
import com.pet.model.Pet;
import com.pet.model.ProcAppDate;
import com.pet.model.ProcLastInsertId;
import com.pet.model.Schedule;
import com.pet.model.Species;

public class DrugTypeDao {
	private SqlSessionFactory sfactory;
	public DrugTypeDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	public void saveDrugType(DrugType dt) {
		try {					
			SqlSession s = this.sfactory.openSession();
			DrugTypeMapper dtm = s.getMapper(DrugTypeMapper.class);
			dtm.insertDrugType(dt);
            // my generated ID
			dt.getDrugId();
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getLastInsertId(String dName,int dDuration,String dDurationType){
		ProcLastInsertId myP=new ProcLastInsertId();
		try {
			SqlSession s = this.sfactory.openSession();
			ProcAnnotationMapper pm = s.getMapper(ProcAnnotationMapper.class);
			 pm.procCall1(dName,dDuration,dDurationType,myP);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DRUG ID IN DAO : "+myP.getLastId());
		return myP.getLastId();
		
	}

	public List<DrugType> getAll() {
		List<DrugType> l = new ArrayList<DrugType>();
		try {
			SqlSession s = this.sfactory.openSession();
			DrugTypeMapper dm = s.getMapper(DrugTypeMapper.class);
			l = dm.getAll();
			s.commit();
			s.close();
		} catch (Exception e) {
		}
		return l == null || l.isEmpty() || l.get(0) == null ? null : l;
	}

	public List<DrugType> getDrugTypeById(int id) {
		List<DrugType> l = new ArrayList<DrugType>();
		try {
			SqlSession s = this.sfactory.openSession();
			DrugTypeMapper dm = s.getMapper(DrugTypeMapper.class);
			l = dm.getDrugById(id);
			s.commit();
			s.close();
		} catch (Exception e) {
		}
		return l == null || l.isEmpty() || l.get(0) == null ? null : l;		
	}
}
