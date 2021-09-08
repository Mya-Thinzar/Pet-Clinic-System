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

import com.pet.form.UserLoginForm;
import com.pet.service.GeneralService;

@WebServlet(urlPatterns = "/loginPath")
public class UserLoginController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Login Controller DO GET");
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Login Controller DO POST");
		UserLoginForm myForm = new UserLoginForm();
		myForm.setFrmId(req.getParameter("frmId"));
		myForm.setFrmPassword(req.getParameter("frmPassword"));
		req.setAttribute("id", req.getParameter("frmId"));
		req.setAttribute("password", req.getParameter("frmPassword"));
		System.out.println("CONTROLLER TRACE: " + myForm.getFrmId() + "," + myForm.getFrmPassword());
		this.myService.processUserLogin(myForm);
		if (this.myService.myUserLogin != null) {
			if (this.myService.myUserLogin.getLoginId().startsWith("id")) {
				req.setAttribute("myFormLogin", myForm);
				RequestDispatcher rd = req.getRequestDispatcher("admin_home.jsp");
				rd.forward(req, resp);
				System.out.println("Login Success!!");
			} else if (this.myService.myUserLogin.getLoginId().startsWith("did")) {
				req.setAttribute("myFormLogin", myForm);
				RequestDispatcher rd = req.getRequestDispatcher("doctor_home.jsp");
				rd.forward(req, resp);
				System.out.println("Login Success!!");
			} else if (this.myService.myUserLogin.getLoginId().startsWith("oid")) {
				req.setAttribute("myFormLogin", myForm);
				RequestDispatcher rd = req.getRequestDispatcher("owner_home.jsp");
				rd.forward(req, resp);
				System.out.println("Login Success!!");
			}
		} else {
			req.setAttribute("myFormLogin", myForm);
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
			System.out.println("Login Failed!!");
		}

	}

}
