package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.mapper.OwnerMapper;
import com.pet.mapper.SpeciesMapper;
import com.pet.model.Owner;
import com.pet.model.Species;

public class SpeciesDao {
	private SqlSessionFactory sfactory;

	public SpeciesDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	public void updateSpecies(Species myS) {
		try {
			SqlSession s = this.sfactory.openSession();
			SpeciesMapper sm = s.getMapper(SpeciesMapper.class);
			sm.updateSpecies(myS);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Species> getSpeciesById(String sId) {
		List<Species> l = new ArrayList<Species>();
		try {
			SqlSession s = this.sfactory.openSession();
			SpeciesMapper om = s.getMapper(SpeciesMapper.class);
			l = om.getSpeciesById(sId);
			s.commit();
			s.close();
		} catch (Exception e) {
		}
		return l == null || l.isEmpty() || l.get(0) == null ? null : l;
	}

	public void saveSpecies(Species myS) {
		try {
			SqlSession s = this.sfactory.openSession();
			SpeciesMapper sm = s.getMapper(SpeciesMapper.class);
			sm.insertSpecies(myS);
			;
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Species> getAll() {
		List<Species> l = new ArrayList<Species>();
		try {
			SqlSession s = this.sfactory.openSession();
			SpeciesMapper sm = s.getMapper(SpeciesMapper.class);
			l = sm.getAll();
			s.commit();
			s.close();
		} catch (Exception e) {
		}
		return l == null || l.isEmpty() || l.get(0) == null ? null : l;
	}
}
