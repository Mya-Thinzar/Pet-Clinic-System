package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.mapper.OwnerMapper;
import com.pet.mapper.PaymentMapper;
import com.pet.mapper.PetMapper;
import com.pet.mapper.ProcAnnotationMapper;
import com.pet.mapper.ScheduleMapper;
import com.pet.mapper.SpeciesMapper;
import com.pet.model.Owner;
import com.pet.model.Payment;
import com.pet.model.Pet;
import com.pet.model.ProcAppDate;
import com.pet.model.Schedule;
import com.pet.model.Species;

public class PaymentDao {
	private SqlSessionFactory sfactory;

	public PaymentDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	public void savePayment(Payment p) {
		try {
			SqlSession s = this.sfactory.openSession();
			PaymentMapper pm = s.getMapper(PaymentMapper.class);
			pm.insertPayment(p);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Payment> getAllPayments() {
		List<Payment> l = null;
		try {
			SqlSession s = this.sfactory.openSession();
			PaymentMapper pm = s.getMapper(PaymentMapper.class);
			l = pm.getAllPayments();
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l == null || l.isEmpty() ? null : l;
	}


	
}
