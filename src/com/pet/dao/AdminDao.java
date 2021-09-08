package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.form.UserLoginForm;
import com.pet.mapper.AdminRegisterMapper;
import com.pet.mapper.DoctorMapper;
import com.pet.model.Doctor;
import com.pet.model.PetUserLogin;

public class AdminDao {
	private SqlSessionFactory sfactory;

	public AdminDao(SqlSessionFactory sf) {
		this.sfactory = sf;
		System.out.println("Dao CONSTRUCTOR :" + this.sfactory);
	}

	public void updatePassword(PetUserLogin myUser) {
		try {
			System.out.println("Dao Trace 1: " + myUser.getLoginId() + "," + myUser.getloginPassword());
			SqlSession s = this.sfactory.openSession();
			AdminRegisterMapper am = s.getMapper(AdminRegisterMapper.class);
			am.updateUser(myUser);
			System.out.println("Update Success!!!!");
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveAdmin(PetUserLogin myAdmin) {
		try {
			System.out.println("Dao Trace 1: " + myAdmin.getLoginId() + "," + myAdmin.getloginPassword());
			SqlSession s = this.sfactory.openSession();
			AdminRegisterMapper am = s.getMapper(AdminRegisterMapper.class);
			am.insertAdmin(myAdmin);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
