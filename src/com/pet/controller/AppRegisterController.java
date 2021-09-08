package com.pet.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.form.AppointmentForm;
import com.pet.form.DoctorForm;
import com.pet.form.OwnerForm;
import com.pet.form.PetForm;
import com.pet.form.ScheduleForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.model.ProcAppDate;
import com.pet.model.Schedule;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/registerAppPath")
public class AppRegisterController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Appointment Controller DO GET");
		//get action from link
		String action=req.getParameter("action");
		req.setAttribute("action", action);
		//get owner id
		req.setAttribute("frmOwnerId", req.getParameter("frmOwnerId"));
		// load Schedule
		ScheduleForm myForm1 = new ScheduleForm();
			this.myService.processLoadScheduleForApp(myForm1);
			req.setAttribute("myScheduleForm1", myForm1);
		
		//load date
			ProcAppDate a=new ProcAppDate();
			this.myService.processDate(a);
			req.setAttribute("date", a);
			String strDate=a.getCurDate();
			String strFormatDate=DateUtil.dateFormat(strDate);
			req.setAttribute("frmAppDate", strFormatDate);
			System.out.println("date : "+strFormatDate);

		//load AppointmentList
			AppointmentForm myForm = new AppointmentForm();
			if (myForm != null) {
				this.myService.processLoadAppointment(myForm);
				req.setAttribute("myAppForm", myForm);
			}
		RequestDispatcher rd = req.getRequestDispatcher("register_appointment.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Appointment Controller DO POST");
		
		//save appointment
		
		String oid=req.getParameter("frmOwnerId");
		String appDate=req.getParameter("frmAppDate");
		String appTime=req.getParameter("frmAppTime");
		
		AppointmentForm myForm=new AppointmentForm();
		myForm.setFrmOwnerId(oid);
		myForm.setFrmAppDate(appDate);
		myForm.setFrmAppTime(appTime);
		
		this.myService.processSaveAppointment(myForm);
		System.out.println("SAVE SUCCESS!!!");
		doGet(req,resp);
	}
}
