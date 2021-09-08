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
import com.pet.form.PetForm;
import com.pet.form.ScheduleForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.model.Schedule;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/registerSchedulePath")
public class ScheduleRegisterControler extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Schedule Controller DO GET");
		String frmDoctorId=req.getParameter("frmDoctorId");
		req.setAttribute("frmDoctorId", frmDoctorId);
		
		// load Schedule
		ScheduleForm myForm1 = new ScheduleForm();
		if (myForm1 != null) {
			myForm1.setFrmDoctorId(frmDoctorId);
			this.myService.processLoadSchedule(myForm1);
			req.setAttribute("myScheduleForm", myForm1);
		}
		RequestDispatcher rd = req.getRequestDispatcher("register_schedule.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Schedule Controller DO POST");
		String did=req.getParameter("frmDoctorId");
		String day=req.getParameter("frmDay");
		String startTime=req.getParameter("frmStartTime");
		String endTime=req.getParameter("frmEndTime");
		
		ScheduleForm myForm=new ScheduleForm();
		myForm.setFrmDoctorId(did);
		myForm.setFrmDayName(day);
		myForm.setFrmStartTime(startTime);
		myForm.setFrmEndTime(endTime);
		
		System.out.println("DOCTOR ID IN SCH CONTROLLER: "+did);
		System.out.println("DAY IN SCH CONTROLLER: "+day);
		System.out.println("START TIME IN SCH CONTROLLER: "+startTime);
		System.out.println("END TIME IN SCH CONTROLLER: "+endTime);
		
		this.myService.processSaveSchedule(myForm);
		req.setAttribute("myScheduleForm", myForm);		
		doGet(req,resp);
	}
}
