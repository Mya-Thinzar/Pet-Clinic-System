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
import com.pet.form.PaymentForm;
import com.pet.form.UserLoginForm;
import com.pet.service.GeneralService;

@WebServlet(urlPatterns = "/paymentPath")
public class PaymentController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PAYMENT Controller DO GET");
		//load payment list
		PaymentForm myForm=new PaymentForm();
		this.myService.processLoadPayment(myForm);
		req.setAttribute("myPaymentForm", myForm);
		RequestDispatcher rd = req.getRequestDispatcher("payment.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PAYMENT Controller DO POST");
		//save payment
		PaymentForm myForm=new PaymentForm();
		myForm.setFrmVoucherNo(req.getParameter("frmVoucherNo"));
		myForm.setFrmPaymentDate(req.getParameter("frmPaymentDate"));
		myForm.setFrmPaymentAmt(req.getParameter("frmPaymentAmt"));
		myForm.setFrmPaymentStatus(req.getParameter("frmPaymentStatus"));
		
		this.myService.processSavePayment(myForm);
		req.setAttribute("myPaymentForm", myForm);
		System.out.println("SAVE SUCCESS!!!!");
		doGet(req, resp);
	}
}
