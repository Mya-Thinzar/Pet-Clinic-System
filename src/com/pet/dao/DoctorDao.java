package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.pet.mapper.DoctorMapper;
import com.pet.model.Doctor;

public class DoctorDao {
	private SqlSessionFactory sfactory;

	public DoctorDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	public void saveDoctor(Doctor d) {
		try {
			SqlSession s = this.sfactory.openSession();
			DoctorMapper dm = s.getMapper(DoctorMapper.class);
			dm.insertDoctor(d);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Doctor> getAll() {
		List<Doctor> l = new ArrayList<Doctor>();
		try {
			SqlSession s = this.sfactory.openSession();
			DoctorMapper dm = s.getMapper(DoctorMapper.class);
			l = dm.getAll();
			s.commit();
			s.close();
		} catch (Exception e) {
		}
		return l == null || l.isEmpty() || l.get(0) == null ? null : l;
	}

	public List<Doctor> getDoctorById(String did) {
		List<Doctor> l = new ArrayList<Doctor>();
		try {
			SqlSession s = this.sfactory.openSession();
			DoctorMapper dm = s.getMapper(DoctorMapper.class);
			l = dm.getDoctorById(did);
			s.commit();
			s.close();
		} catch (Exception e) {
		}
		return l == null || l.isEmpty() || l.get(0) == null ? null : l;
	}

	public void updateDoctor(Doctor myD) {
		try {
			SqlSession s = this.sfactory.openSession();
			DoctorMapper dm = s.getMapper(DoctorMapper.class);
			dm.updateDoctor(myD);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
