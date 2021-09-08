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
import com.pet.form.ScheduleForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/updateSchedulePath")
public class ScheduleUpdateController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Sch Update Controller DO GET");

		//dispatch doctorId,schId
		String sid=req.getParameter("frmScheduleId");
		String did=req.getParameter("frmDoctorId");

		System.out.println("SCHEDULE ID IN SCH UPDATE DO GET :"+sid);
		System.out.println("DOCTOR ID IN SCH UPDATE DO GET :"+did);

		req.setAttribute("frmScheduleId", sid);
		req.setAttribute("frmDoctorId",did);
		
		// load SCHEDULE
		ScheduleForm myForm1 = new ScheduleForm();
		if (myForm1 != null) {
			myForm1.setFrmDoctorId(did);
			myForm1.setFrmScheduleId(Integer.parseInt(sid));

			this.myService.processLoadScheduleById(myForm1);
			req.setAttribute("myScheduleForm1", myForm1);
			System.out.println("IS FORM ? "+myForm1.getFrmDoctorId());
			System.out.println("IS FORM ? "+myForm1.getFrmScheduleId());
		}

		RequestDispatcher rd = req.getRequestDispatcher("update_schedule.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Schedule Controller DO POST");
		
		// update schedule
		ScheduleForm myForm = new ScheduleForm();

		String did=req.getParameter("frmDoctorId");
		String sid=req.getParameter("frmScheduleId");
		String day=req.getParameter("frmDay");
		String startTime=req.getParameter("frmStartTime");
		String endTime=req.getParameter("frmEndTime");
	
		System.out.println("Sch Id : " + sid);
		System.out.println("doctor Id : " + did);

		myForm.setFrmDoctorId(did);
		myForm.setFrmScheduleId(Integer.parseInt(sid));
		myForm.setFrmDayName(day);
		myForm.setFrmStartTime(startTime);
		myForm.setFrmEndTime(endTime);
		this.myService.processUpdateSchedule(myForm);
		req.setAttribute("myScheduleForm", myForm);
		System.out.println("SAVE SUCCESS!!!!");
		req.setAttribute("frmScheduleId", sid);

		// load SCHEDULE
		ScheduleForm myForm1 = new ScheduleForm();
		if (myForm1 != null) {
			myForm1.setFrmDoctorId(did);
			myForm1.setFrmScheduleId(Integer.parseInt(sid));

			this.myService.processLoadScheduleById(myForm1);
			req.setAttribute("myScheduleForm1", myForm1);
			System.out.println("IS FORM ? "+myForm1.getFrmDoctorId());
			System.out.println("IS FORM ? "+myForm1.getFrmScheduleId());
		}
		RequestDispatcher rd = req.getRequestDispatcher("update_schedule.jsp");
		rd.forward(req, resp);
	}
}
