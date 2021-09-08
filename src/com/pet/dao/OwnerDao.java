package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.mapper.DoctorMapper;
import com.pet.mapper.OwnerMapper;
import com.pet.model.Doctor;
import com.pet.model.Owner;

public class OwnerDao {
	private SqlSessionFactory sfactory;

	public OwnerDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	public void updateOwner(Owner myOwner) {
		try {
			SqlSession s = this.sfactory.openSession();
			OwnerMapper om = s.getMapper(OwnerMapper.class);
			om.updateOwner(myOwner);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveOwner(Owner myOwner) {
		try {
			SqlSession s = this.sfactory.openSession();
			OwnerMapper om = s.getMapper(OwnerMapper.class);
			om.insertOwner(myOwner);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Owner> getAll() {
		List<Owner> l = new ArrayList<Owner>();
		try {
			SqlSession s = this.sfactory.openSession();
			OwnerMapper om = s.getMapper(OwnerMapper.class);
			l = om.getAll();
			s.commit();
			s.close();
		} catch (Exception e) {
		}
		return l == null || l.isEmpty() || l.get(0) == null ? null : l;
	}

	public List<Owner> getOwnerbyId(String ownerId) {
		List<Owner> l = new ArrayList<Owner>();
		try {
			SqlSession s = this.sfactory.openSession();
			OwnerMapper om = s.getMapper(OwnerMapper.class);
			l = om.getOwnerById(ownerId);
			s.commit();
			s.close();
		} catch (Exception e) {
		}
		return l == null || l.isEmpty() || l.get(0) == null ? null : l;
	}
}
