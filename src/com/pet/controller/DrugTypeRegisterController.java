package com.pet.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.form.DrugTypeForm;
import com.pet.form.OwnerForm;
import com.pet.form.PetForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.model.DrugType;
import com.pet.model.ProcAppDate;
import com.pet.model.ProcLastInsertId;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/registerDrugTypePath")
public class DrugTypeRegisterController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Drug Type Controller Do Get");
		//get doctor id
		String did=req.getParameter("frmDoctorId");
		req.setAttribute("frmDoctorId", did);
		
		//load all Drug Type
		DrugTypeForm myForm=new DrugTypeForm();
		this.myService.processLoadDrugType(myForm);
		req.setAttribute("myDrugTypeForm", myForm);
		RequestDispatcher rd = req.getRequestDispatcher("register_drug_type.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Drug Type Controller DO POST");
		//load id
		ProcLastInsertId p=new ProcLastInsertId();
		//this.myService.processDate(a);
		//req.setAttribute("date", a);
		//String strDate=a.getCurDate();
		//String strFormatDate=DateUtil.dateFormat(strDate);
		//req.setAttribute("frmAppDate", strFormatDate);
		//System.out.println("date : "+strFormatDate);
		
		DrugTypeForm myForm=new DrugTypeForm();
		myForm.setFrmDrugName(req.getParameter("frmName"));
		myForm.setFrmDrugDuration(req.getParameter("frmDuration"));
		myForm.setFrmDrugDurationType(req.getParameter("frmDurationType"));
		this.myService.processSaveAndGetId(p,myForm);
		req.setAttribute("myDrugTypeForm", myForm);
		System.out.println("DRUG ID IN CONTROLLER : "+p.getLastId());
		System.out.println("DRUG ID IN CONTROLLER : "+myForm.getFrmDrugId());
		doGet(req,resp);
		
	}
}
