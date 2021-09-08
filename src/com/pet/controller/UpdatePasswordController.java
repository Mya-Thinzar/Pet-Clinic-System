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

@WebServlet(urlPatterns = "/updatePwPath")
public class UpdatePasswordController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Update Password Controller DO GET");
		String frmId = req.getParameter("frmId");
		String frmPw = req.getParameter("frmPw");
		req.setAttribute("frmId", frmId);
		req.setAttribute("frmPw", frmPw);
		RequestDispatcher rd = req.getRequestDispatcher("update_pw.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Update Controller DO POST");
		UserLoginForm myForm = new UserLoginForm();
		String frmId = req.getParameter("frmId");
		String frmPassword = req.getParameter("frmPassword");
		System.out.println("UPDATE Id :" + frmId);
		System.out.println("UPDATE PASSWORD :" + frmPassword);
		myForm.setFrmId(frmId);
		myForm.setFrmPassword(frmPassword);
		this.myService.processUpdatePassword(myForm);
		doGet(req,resp);
	}
}
