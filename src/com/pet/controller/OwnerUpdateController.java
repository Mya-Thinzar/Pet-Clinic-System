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

@WebServlet(urlPatterns = "/updateOwnerPath")
public class OwnerUpdateController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("frmAction");
		System.out.println("Owner Update Controller DO GET");
		String frmOwnerId = req.getParameter("frmOwnerId");
		OwnerForm myForm = new OwnerForm();
		this.myService.processLoadOwnerById(myForm, frmOwnerId);

		req.setAttribute("action", action);
		req.setAttribute("myOwnerForm", myForm);
		req.setAttribute("frmOwnerId", frmOwnerId);
		System.out.println("owner id Trace : " + frmOwnerId);

		RequestDispatcher rd = req.getRequestDispatcher("update_owner.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Owner Update Controller DO POST");
		// update owner
		OwnerForm myForm = new OwnerForm();

		String id = req.getParameter("frmOwnerId");

		myForm.setFrmId(id);
		System.out.println("Controller trace: id =" + id);
		myForm.setFrmName(req.getParameter("frmName"));
		myForm.setFrmPhone(req.getParameter("frmPhone"));
		myForm.setFrmEmail(req.getParameter("frmEmail"));
		myForm.setFrmAddress(req.getParameter("frmAddress"));
		this.myService.processUpdateOwner(myForm);
		req.setAttribute("frmOwnerForm", myForm);
		System.out.println("Owner Id TRACE: " + myForm.getFrmId());

		doGet(req, resp);
	}
}
