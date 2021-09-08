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
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/registerPetPath")
@MultipartConfig(maxFileSize = 2097152, maxRequestSize = 2097152, fileSizeThreshold = 1097152)
public class PetRegisterController extends HttpServlet {

	private GeneralService myService;
	private String dirPath;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.dirPath = (String) config.getServletContext().getAttribute("RootDirPath");
		System.out.println("Dir Path in init Trace : " + dirPath);
		this.myService = new GeneralService((SqlSessionFactory) config.getServletContext().getAttribute("SF"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Pet Controller DO GET");
		//get sql param from link
		String sql=req.getParameter("sql");
		req.setAttribute("sql", sql);
		// load species combo box
		SpeciesForm myForm = new SpeciesForm();

		myForm.setFrmOwnerId(req.getParameter("frmOwnerId"));
		this.myService.processLoadSpecies(myForm);

		req.setAttribute("mySpeciesForm", myForm);
		req.setAttribute("frmOwnerId", myForm.getFrmOwnerId());
		System.out.println("Owner Id: " + myForm.getFrmOwnerId());

		// load pets
		PetForm myForm1 = new PetForm();
		if (myForm1 != null) {
			myForm1.setFrmOwnerId(req.getParameter("frmOwnerId"));
			this.myService.processLoadPets(myForm1);
			req.setAttribute("myPetForm", myForm1);
		}

		RequestDispatcher rd = req.getRequestDispatcher("register_pet.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Pet Controller DO POST");
		// save pet
		PetForm myForm = new PetForm();
		String speciesId = req.getParameter("frmSpeciesId");
		String ownerId = req.getParameter("frmOwnerId");
		String petId = req.getParameter("frmId");
		String name = req.getParameter("frmName");
		String sex = req.getParameter("frmSex");
		String bDate = req.getParameter("frmBirthDate");
		String dDate = req.getParameter("frmDeathDate");

		myForm.setFrmSpeciesId(Integer.parseInt(speciesId));
		myForm.setFrmOwnerId(ownerId);
		myForm.setFrmId(petId);
		myForm.setFrmName(name);
		myForm.setFrmSex(sex);
		myForm.setFrmBirthDate(DateUtil.convertS2D(bDate));
		myForm.setFrmDeathDate(DateUtil.convertS2D(dDate));

		System.out.println("Species Id : " + speciesId);
		System.out.println("Owner Id : " + ownerId);
		System.out.println("Pet Id : " + petId);
		System.out.println("Pet Name : " + name);
		System.out.println("Pet Sex : " + sex);
		System.out.println("Pet bDate : " + bDate);
		System.out.println("Pet dDate : " + dDate);

		this.myService.processSavePet(myForm);
		req.setAttribute("myPetForm", myForm);
		System.out.println("SAVE SUCCESS!!!!");

		SpeciesForm mySpeciesForm = new SpeciesForm();

		myForm.setFrmOwnerId(req.getParameter("frmOwnerId"));
		this.myService.processLoadSpecies(mySpeciesForm);
		req.setAttribute("mySpeciesForm", myForm);
		req.setAttribute("frmOwnerId", myForm.getFrmOwnerId());
		System.out.println("Owner Id: " + myForm.getFrmOwnerId());
		
		// save image under server
		String imageName = new String();
		String strOwnerId = req.getParameter("frmOwnerId");
		String strPetId = req.getParameter("frmId");
		System.out.println("Pet Id Trace: " + strPetId);
		imageName = "pet_id_";
		imageName += strPetId.substring(4);
		System.out.println("Image Name Trace: " + imageName);

		Part partFile = req.getPart("frmFile");

		System.out.println("Check Owner Id =" + strOwnerId);
		System.out.println("Check Part =" + partFile.getSubmittedFileName());

		// String
		// dirPath=(String)getServletContext().getAttribute("RootDirPath");
		String fileName = strOwnerId;
		String filePath = dirPath + File.separator + fileName;
		File f = new File(filePath);
		f.mkdir();
		try {
			// upload file into folder
			InputStream inData = partFile.getInputStream();
			FileOutputStream fos = new FileOutputStream(new File(filePath + File.separator + imageName + ".jpg"));
			long fileSize = partFile.getSize();
			byte buf[] = new byte[(int) fileSize];
			inData.read(buf);
			fos.write(buf);
			fos.close();
			inData.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		doGet(req, resp);
	}
}
