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

import com.pet.form.DoctorForm;
import com.pet.form.OwnerForm;
import com.pet.form.PetForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.model.Doctor;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/updateDoctorPath")
public class DoctorUpdateController extends HttpServlet {

	private GeneralService myService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Doctor Update Controller DO GET");
		String frmDoctorId = req.getParameter("frmDoctorId");
		String frmDoctorPassword=req.getParameter("frmDoctorPassword");
		String action=req.getParameter("action");
		req.setAttribute("frmDoctorId", frmDoctorId);
		req.setAttribute("frmDoctorPassword", frmDoctorPassword);
		req.setAttribute("action", action);
		DoctorForm myForm = new DoctorForm();
		this.myService.processLoadDoctorById(myForm, frmDoctorId);
		
		System.out.println("DOCTOR ID IN UPDATE CONTROLLLER TRACE :"+frmDoctorId);
		//System.out.println("FORM LIST IN UPDATE CONTROLLLER TRACE :"+myForm.getFrmDoctorList().size());
		
		req.setAttribute("frmDid", frmDoctorId);
		req.setAttribute("frmDoctorForm", myForm);
		RequestDispatcher rd = req.getRequestDispatcher("update_doctor.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Species Update Controller DO POST");
		// update doctor
		DoctorForm myForm = new DoctorForm();

		String id = req.getParameter("frmDoctorId");
		String name = req.getParameter("frmName");
		String rank = req.getParameter("frmRank");
		myForm.setFrmId(id);
		myForm.setFrmId(id);
		myForm.setFrmName(name);
		myForm.setFrmRank(rank);

		this.myService.processUpdateDoctor(myForm);
		req.setAttribute("frmDoctorForm", myForm);
		System.out.println("UPDATE DOCTOR Id TRACE: " + myForm.getFrmId());
		System.out.println("UPDATE Name TRACE: " + myForm.getFrmName());
		doGet(req, resp);
	}
}
