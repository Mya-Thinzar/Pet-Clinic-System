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

import com.pet.dao.UserLoginDao;
import com.pet.form.UserLoginForm;
import com.pet.service.GeneralService;

@WebServlet(urlPatterns = "/registerPath")
public class AdminRegisterController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get sql param from link
		String sql=req.getParameter("sql");
		req.setAttribute("sql", sql);
		
		System.out.println("Admin Controller DO GET");
		UserLoginForm myForm = new UserLoginForm();
		myForm.setFrmId(req.getParameter("id"));
		myForm.setFrmPassword(req.getParameter("pw"));
		this.myService.processUserLogin(myForm);
		req.setAttribute("myUserForm", myForm);
		RequestDispatcher rd = req.getRequestDispatcher("register_admin.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Admin Controller DO POST");
		UserLoginForm myForm = new UserLoginForm();
		String id = req.getParameter("frmId");
		String password = req.getParameter("frmPassword");
		myForm.setFrmId(id);
		myForm.setFrmPassword(password);
		this.myService.processSaveUserLogin(myForm);

		doGet(req, resp);
	}
}
