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
import com.pet.form.OwnerForm;
import com.pet.form.PetForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/updateSpeciesPath")
public class SpeciesUpdateController extends HttpServlet {

	private GeneralService myService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Species Update Controller DO GET");
		String frmSpeciesId = req.getParameter("frmSpeciesId");
		SpeciesForm myForm = new SpeciesForm();
		this.myService.processLoadSpeciesById(myForm, frmSpeciesId);

		req.setAttribute("mySpeciesForm", myForm);
		req.setAttribute("frmSpeciesId", frmSpeciesId);
		System.out.println("species id Trace : " + frmSpeciesId);

		RequestDispatcher rd = req.getRequestDispatcher("update_species.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Species Update Controller DO POST");
		// update species
		SpeciesForm myForm = new SpeciesForm();

		String id = req.getParameter("frmSpeciesId");

		myForm.setFrmSpeciesId(id);
		myForm.setFrmName(req.getParameter("frmName"));

		this.myService.processUpdateSpecies(myForm);
		req.setAttribute("mySpeciesForm", myForm);
		System.out.println("Species Id TRACE: " + myForm.getFrmSpeciesId());
		System.out.println("Species Name TRACE: " + myForm.getFrmName());
		doGet(req, resp);
	}
}
