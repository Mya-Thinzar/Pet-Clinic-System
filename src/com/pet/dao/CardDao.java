package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.mapper.CardMapper;
import com.pet.mapper.OwnerMapper;
import com.pet.mapper.PaymentMapper;
import com.pet.mapper.PetMapper;
import com.pet.mapper.ProcAnnotationMapper;
import com.pet.mapper.ScheduleMapper;
import com.pet.mapper.SpeciesMapper;
import com.pet.model.Card;
import com.pet.model.Owner;
import com.pet.model.Payment;
import com.pet.model.Pet;
import com.pet.model.ProcAppDate;
import com.pet.model.Schedule;
import com.pet.model.Species;

public class CardDao {
	private SqlSessionFactory sfactory;

	public CardDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	public void saveCard(Card c) {
		try {
			SqlSession s = this.sfactory.openSession();
			CardMapper pm = s.getMapper(CardMapper.class);
			pm.insertCard(c);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	
}
