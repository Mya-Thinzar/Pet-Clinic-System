package com.pet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.form.DoctorForm;
import com.pet.form.OwnerForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.service.GeneralService;

@WebServlet(urlPatterns = "/registerSpeciesPath")
public class SpecisRegisterController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Species Controller DO GET");
		SpeciesForm myForm = new SpeciesForm();

		myForm.setFrmOwnerId(req.getParameter("frmOwnerId"));
		this.myService.processLoadSpecies(myForm);

		req.setAttribute("mySpeciesForm", myForm);
		req.setAttribute("frmOwnerId", myForm.getFrmOwnerId());
		System.out.println("Owner Id: " + myForm.getFrmOwnerId());

		String action = req.getParameter("action");
		req.setAttribute("action", action);
		RequestDispatcher rd = req.getRequestDispatcher("register_species.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Species Controller DO POST");

		SpeciesForm myForm = new SpeciesForm();

		myForm.setFrmName(req.getParameter("frmName"));
		myForm.setFrmOwnerId(req.getParameter("frmOwnerId"));
		req.setAttribute("mySpeciesForm", myForm);

		this.myService.processSaveSpecies(myForm);
		System.out.println("SAVE SUCCESS!!!!");
		doGet(req, resp);
	}
}
