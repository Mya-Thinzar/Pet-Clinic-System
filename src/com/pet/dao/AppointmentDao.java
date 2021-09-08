package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.mapper.AppointmentMapper;
import com.pet.mapper.OwnerMapper;
import com.pet.mapper.PetMapper;
import com.pet.mapper.ProcAnnotationMapper;
import com.pet.mapper.ScheduleMapper;
import com.pet.mapper.SpeciesMapper;
import com.pet.model.Appointment;
import com.pet.model.Owner;
import com.pet.model.Pet;
import com.pet.model.ProcAppDate;
import com.pet.model.Schedule;
import com.pet.model.Species;

public class AppointmentDao {
	private SqlSessionFactory sfactory;

	public AppointmentDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	public void saveAppointment(Appointment ap) {
		try {			
			SqlSession s = this.sfactory.openSession();
			AppointmentMapper sm = s.getMapper(AppointmentMapper.class);
			sm.insertApp(ap);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public List<Appointment> getAllAppointments() {
		List<Appointment> l = null;
		try {
			SqlSession s = this.sfactory.openSession();
			AppointmentMapper pm = s.getMapper(AppointmentMapper.class);
			l = pm.getAllAppointments();
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;		
	}

}
