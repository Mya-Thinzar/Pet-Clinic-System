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

import com.pet.form.CardForm;
import com.pet.form.DoctorForm;
import com.pet.form.OwnerForm;
import com.pet.form.PetForm;
import com.pet.form.ScheduleForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.model.Schedule;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/cardPath")
public class CardController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Card Controller DO GET");
		String frmVno=req.getParameter("frmVno");
		req.setAttribute("frmVno", frmVno);
		
		RequestDispatcher rd = req.getRequestDispatcher("card.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Card Controller DO POST");
		CardForm myForm=new CardForm();
		myForm.setFrmCardNumber(req.getParameter("frmCardNo"));
		myForm.setFrmVoucherNo(req.getParameter("frmVno"));
		this.myService.processSaveCard(myForm);
		req.setAttribute("myCardForm", myForm);
		doGet(req,resp);
	}
}
