package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.mapper.OwnerMapper;
import com.pet.mapper.PetMapper;
import com.pet.mapper.ProcAnnotationMapper;
import com.pet.mapper.ScheduleMapper;
import com.pet.mapper.SpeciesMapper;
import com.pet.model.Owner;
import com.pet.model.Pet;
import com.pet.model.ProcAppDate;
import com.pet.model.Schedule;
import com.pet.model.Species;

public class ScheduleDao {
	private SqlSessionFactory sfactory;

	public ScheduleDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	public void saveSchedule(Schedule myS) {
		try {
			System.out.println("SART TIME IN DAO TRACE: "+myS.getStartTime());
			System.out.println("END TIME IN DAO TRACE: "+myS.getEndTime());
			
			SqlSession s = this.sfactory.openSession();
			ScheduleMapper sm = s.getMapper(ScheduleMapper.class);
			sm.insertSchedule(myS);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Schedule> getAllScheduleByDoctorId(String did) {
		List<Schedule> l = null;
		try {
			SqlSession s = this.sfactory.openSession();
			ScheduleMapper sm = s.getMapper(ScheduleMapper.class);
			l = sm.getAllScheduleByDoctorId(did);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;
	}

	public List<Schedule> getScheduleById(String did, Integer sid) {
		List<Schedule> l = null;
		try {
			System.out.println("Schedule Dao Trace:" + did + "," + sid);
			SqlSession s = this.sfactory.openSession();
			ScheduleMapper pm = s.getMapper(ScheduleMapper.class);
			l = pm.getScheduleById(did, sid);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;
	}

	public void updateSchedule(Schedule myS) {
		try {
			System.out.println("SART TIME IN DAO TRACE: "+myS.getStartTime());
			System.out.println("END TIME IN DAO TRACE: "+myS.getEndTime());
			
			SqlSession s = this.sfactory.openSession();
			ScheduleMapper sm = s.getMapper(ScheduleMapper.class);
			sm.updateSchedule(myS);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public List<Schedule> getScheduleForApp() {
		List<Schedule> l = null;
		try {
			SqlSession s = this.sfactory.openSession();
			ScheduleMapper pm = s.getMapper(ScheduleMapper.class);
			l = pm.getScheduleForApp();
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;		
	}
	public String getCurDate(){
		ProcAppDate p=new ProcAppDate();
		try {
			SqlSession s = this.sfactory.openSession();
			ProcAnnotationMapper pm = s.getMapper(ProcAnnotationMapper.class);
			 pm.procCall(p);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p.getCurDate();
	}

}
