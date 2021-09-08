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

@WebServlet(urlPatterns = "/searchPetTreatmentPath")
public class PetSearchTreatmentController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Pet Drug Controller Do Get");
		//get doctor id
		String did=req.getParameter("frmDoctorId");
		req.setAttribute("frmDoctorId", did);

		//load all Drug Type
		DrugTypeForm myForm=new DrugTypeForm();
		this.myService.processLoadDrugType(myForm);
		req.setAttribute("myDrugTypeForm", myForm);
		
		//load all pets
		PetForm myForm1=new PetForm();
		this.myService.processLoadPetsForTreatment(myForm1);
		req.setAttribute("myPetForm1", myForm1);
		RequestDispatcher rd = req.getRequestDispatcher("search_pet_treatment.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Pet Drug Controller DO POST");
		
		//get doctor id
		String did=req.getParameter("frmDoctorId");
		req.setAttribute("frmDoctorId", did);
		
		PetForm myForm=new PetForm();
		String pid=req.getParameter("frmPetId");
		this.myService.processLoadPetByPetId(myForm, pid);
		req.setAttribute("myPetForm", myForm);
		System.out.println("PET ID TRACE IN PET SEARCH TREATMENT CONTROLLER : "+pid);
		doGet(req,resp);
		
	}
}
