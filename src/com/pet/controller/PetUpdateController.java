package com.pet.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

import com.pet.form.PetForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/updatePetPath")
public class PetUpdateController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Pet Controller DO GET");
		// load species combo box
		SpeciesForm myForm = new SpeciesForm();
		this.myService.processLoadSpecies(myForm);
		req.setAttribute("mySpeciesForm", myForm);
		
		//dispatch SpeciesId,OwnerId,PetId
		String sId=req.getParameter("sId");
		String oId=req.getParameter("oId");
		String pId=req.getParameter("pId");
		System.out.println("SPECIES ID IN PET UPDATE DO GET :"+sId);
		System.out.println("OWNER ID IN PET UPDATE DO GET :"+oId);
		System.out.println("PET ID IN PET UPDATE DO GET :"+pId);
		
		req.setAttribute("frmSpeciesId", sId);
		req.setAttribute("frmOwnerId",oId);
		req.setAttribute("frmPetId", pId);
		
		// load pets
		PetForm myForm1 = new PetForm();
		if (myForm1 != null) {
			myForm1.setFrmOwnerId(oId);
			myForm1.setFrmSpeciesId(Integer.parseInt(sId));
			myForm1.setFrmId(pId);
			this.myService.processLoadPetById(myForm1);
			req.setAttribute("myPetForm1", myForm1);
			System.out.println("IS FORM ? "+myForm1);
		}

		RequestDispatcher rd = req.getRequestDispatcher("update_pet.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Pet Controller DO POST");
		
		// update pet
		PetForm myForm = new PetForm();
		String speciesId = req.getParameter("frmSpeciesId");
		String ownerId = req.getParameter("frmOwnerId");
		String petId = req.getParameter("frmPetId");
		String name = req.getParameter("frmName");
		String sex = req.getParameter("frmSex");
		String bDate = req.getParameter("frmBirthDate");
		String dDate = req.getParameter("frmDeathDate");

		myForm.setFrmSpeciesId(Integer.parseInt(speciesId));
		myForm.setFrmOwnerId(ownerId);
		myForm.setFrmId(petId);
		myForm.setFrmName(name);
		myForm.setFrmSex(sex);
		myForm.setFrmBirthDate(DateUtil.convertS2D(bDate));
		myForm.setFrmDeathDate(DateUtil.convertS2D(dDate));

		System.out.println("Species Id : " + speciesId);
		System.out.println("Owner Id : " + ownerId);
		System.out.println("Pet Id : " + petId);
		System.out.println("Pet Name : " + name);
		System.out.println("Pet Sex : " + sex);
		System.out.println("Pet bDate : " + bDate);
		System.out.println("Pet dDate : " + dDate);

		this.myService.processUpdatePet(myForm);
		req.setAttribute("myPetForm", myForm);
		System.out.println("SAVE SUCCESS!!!!");
		req.setAttribute("sId", speciesId);
		
		// load pets
		PetForm myForm1 = new PetForm();
		if (myForm1 != null) {
			myForm1.setFrmOwnerId(ownerId);
			myForm1.setFrmSpeciesId(Integer.parseInt(speciesId));
			myForm1.setFrmId(petId);
			this.myService.processLoadPetById(myForm1);
			req.setAttribute("myPetForm1", myForm1);
			System.out.println("IS FORM ? "+myForm1);
		}
		
		System.out.println("Pet Controller DO GET");
		// load species combo box
		SpeciesForm myForm2 = new SpeciesForm();
		this.myService.processLoadSpecies(myForm2);
		req.setAttribute("mySpeciesForm", myForm2);
		
		RequestDispatcher rd = req.getRequestDispatcher("update_pet.jsp");
		rd.forward(req, resp);
	}
}
