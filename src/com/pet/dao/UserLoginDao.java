package com.pet.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.mapper.UserLoginMapper;
import com.pet.model.PetUserLogin;

public class UserLoginDao {
	private SqlSessionFactory sfactory;

	public UserLoginDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	public PetUserLogin checkLogin(String id, String password) {
		PetUserLogin u = new PetUserLogin();
		try {
			System.out.println("Dao Trace:" + id + "," + password);
			SqlSession s = this.sfactory.openSession();
			UserLoginMapper um = s.getMapper(UserLoginMapper.class);
			u = um.getUser(id, password);
			s.commit();
			s.close();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
