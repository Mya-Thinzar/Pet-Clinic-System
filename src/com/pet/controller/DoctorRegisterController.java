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
import com.pet.form.UserLoginForm;
import com.pet.service.GeneralService;

@WebServlet(urlPatterns = "/registerDoctorPath")
public class DoctorRegisterController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Doctor Controller DO GET");
		DoctorForm myForm = new DoctorForm();
		this.myService.processLoadDoctors(myForm);
		req.setAttribute("frmDoctorForm", myForm);
		RequestDispatcher rd = req.getRequestDispatcher("register_doctor.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Doctor Controller DO POST");
		// save doctor
		DoctorForm myForm = new DoctorForm();
		String id = req.getParameter("frmId");
		String name = req.getParameter("frmName");
		String rank = req.getParameter("frmRank");
		myForm.setFrmId(id);
		myForm.setFrmName(name);
		myForm.setFrmRank(rank);
		this.myService.processSaveDoctor(myForm);
		req.setAttribute("frmDoctorForm", myForm);

		// UserLogin (pet_login)
		UserLoginForm myForm1 = new UserLoginForm();
		String password = req.getParameter("frmPassword");
		myForm1.setFrmId(id);
		myForm1.setFrmPassword(password);

		this.myService.processSaveUserLogin(myForm1);
		System.out.println("SAVE SUCCESS");

		doGet(req, resp);
	}
}
