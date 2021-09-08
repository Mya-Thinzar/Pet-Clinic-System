package com.pet.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

import com.pet.form.DrugTypeForm;
import com.pet.form.OwnerForm;
import com.pet.form.PetDrugForm;
import com.pet.form.PetForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.model.DrugType;
import com.pet.model.DrugType.Type;
import com.pet.model.ProcAppDate;
import com.pet.model.ProcLastInsertId;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/registerPetDrugPath")
public class PetDrugRegisterController extends HttpServlet {

	private GeneralService myService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Pet Drug Controller Do Get");
		// get doctor id
		String did = req.getParameter("frmDoctorId");
		req.setAttribute("frmDoctorId", did);

		// get pet id
		String pid = req.getParameter("frmPetId");
		req.setAttribute("frmPetId", pid);

		// load all Drug Type
		DrugTypeForm myForm = new DrugTypeForm();
		this.myService.processLoadDrugType(myForm);
		req.setAttribute("myDrugTypeForm", myForm);

		// load all pets
		PetForm myForm1 = new PetForm();
		this.myService.processLoadPetsForTreatment(myForm1);
		req.setAttribute("myPetForm", myForm1);
		
		//get frmControl
		String frmControl=req.getParameter("frmControl");
		req.setAttribute("frmControl", frmControl);
		System.out.println("FORM CONTROL TRACE : "+frmControl);
		
		//load pet history
		if(frmControl.equals("petHistory")){
		PetDrugForm myForm2=new PetDrugForm();
		this.myService.processLoadPetHistory(myForm2);
		req.setAttribute("myPetHistoryForm", myForm2);
		System.out.println("PET HISTORY TRACE : "+myForm2);
	
		}
		else if(frmControl.equals("drugTime")){
			PetDrugForm myForm2=new PetDrugForm();
			myForm2.setFrmOwnerId(req.getParameter("frmOwnerId"));
			this.myService.processLoadDrugTime(myForm2);
			req.setAttribute("myDrugTimeForm", myForm2);
			System.out.println("PET DRUG TIME TRACE : "+myForm2);			
		}
	
		RequestDispatcher rd = req.getRequestDispatcher("register_pet_drug.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Pet Drug Controller DO POST");
		
		//dispatch frmControl
		String frmControl=req.getParameter("frmControl");
		req.setAttribute("frmControl", frmControl);
		// save pet drug
		PetDrugForm myForm = new PetDrugForm();
		String drugId = req.getParameter("frmDrugType");
		String doctorId = req.getParameter("frmDoctorId");
		String petId = req.getParameter("frmPetId");
		String date = req.getParameter("frmDate");
		String nextDate = req.getParameter("frmNextDate");
		String desc = req.getParameter("frmDescription");
		
		//load duration and type
		DrugTypeForm myForm1=new DrugTypeForm();
		myForm1.setFrmDrugId(Integer.parseInt(drugId));
		this.myService.processLoadDrugTypeById(myForm1);
		String type=""+myForm1.getFrmDrugTypeList().get(0).getDrugDurationType();
		String n=""+myForm1.getFrmDrugTypeList().get(0).getDrugDuration();
		System.out.println("DURATION TYPE : "+type);
		System.out.println("DURATION : "+n);
		System.out.println("DRUG ID : "+drugId);
		
		if(drugId.equals("34")){
			myForm.setFrmDrugId(Integer.parseInt(drugId));
			myForm.setFrmDoctorId(doctorId);
			myForm.setFrmPetId(petId);
			myForm.setFrmDrugDate(DateUtil.convertS2D(date));
			myForm.setFrmDrugNextDate(DateUtil.convertS2D(nextDate));
			myForm.setFrmDrugDesc(desc);
			this.myService.processSavePetDrug(myForm);
			System.out.println("SAVE SUCCESS!!!!");
		}
		else{
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			Date now=new Date();
			if(type.equals("month")){
			String myDate=sdf.format(now);
			Calendar c=Calendar.getInstance();
			try {
				c.setTime(sdf.parse(myDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			c.add(Calendar.MONTH, Integer.parseInt(n));
			myDate=sdf.format(c.getTime());
			System.out.println("MONTH: "+myDate);
			
			myForm.setFrmDrugId(Integer.parseInt(drugId));
			myForm.setFrmDoctorId(doctorId);
			myForm.setFrmPetId(petId);
			myForm.setFrmDrugDate(DateUtil.convertS2D(date));
			myForm.setFrmDrugNextDate(DateUtil.convertS2D(myDate));
			myForm.setFrmDrugDesc(desc);
			this.myService.processSavePetDrug(myForm);
			System.out.println("SAVE SUCCESS!!!!");
			}
			else if(type.equals("year")){
				String myDate1=sdf.format(now);
				Calendar c1=Calendar.getInstance();
				try {
					c1.setTime(sdf.parse(myDate1));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c1.add(Calendar.YEAR, Integer.parseInt(n));
				myDate1=sdf.format(c1.getTime());
				System.out.println("YEAR: "+myDate1);
				
				myForm.setFrmDrugId(Integer.parseInt(drugId));
				myForm.setFrmDoctorId(doctorId);
				myForm.setFrmPetId(petId);
				myForm.setFrmDrugDate(DateUtil.convertS2D(date));
				myForm.setFrmDrugNextDate(DateUtil.convertS2D(myDate1));
				myForm.setFrmDrugDesc(desc);
				this.myService.processSavePetDrug(myForm);
				System.out.println("SAVE SUCCESS!!!!");
			}
			else{
				String myDate1=sdf.format(now);
				Calendar c1=Calendar.getInstance();
				try {
					c1.setTime(sdf.parse(myDate1));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c1.add(Calendar.DAY_OF_MONTH, Integer.parseInt(n));
				myDate1=sdf.format(c1.getTime());
				System.out.println("DAY: "+myDate1);
				
				myForm.setFrmDrugId(Integer.parseInt(drugId));
				myForm.setFrmDoctorId(doctorId);
				myForm.setFrmPetId(petId);
				myForm.setFrmDrugDate(DateUtil.convertS2D(date));
				myForm.setFrmDrugNextDate(DateUtil.convertS2D(myDate1));
				myForm.setFrmDrugDesc(desc);
				this.myService.processSavePetDrug(myForm);
				System.out.println("SAVE SUCCESS!!!!");
			}
		}
	
		req.setAttribute("myPetDrugForm", myForm);
		req.setAttribute("frmDrugId", drugId);
		req.setAttribute("frmDrugDuration", n);
		req.setAttribute("frmDrugDurationType", type);
		doGet(req,resp);
		
	}
}
