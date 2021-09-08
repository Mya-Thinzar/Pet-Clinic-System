package com.pet.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
import com.pet.form.OwnerForm;
import com.pet.form.PetForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.service.GeneralService;
import com.pet.util.DateUtil;

@WebServlet(urlPatterns = "/registerOwnerPath")
@MultipartConfig(maxFileSize = 2097152, maxRequestSize = 2097152, fileSizeThreshold = 1097152)
public class OwnerRegisterController extends HttpServlet {

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
		// load species combo box
		SpeciesForm myForm1 = new SpeciesForm();

		myForm1.setFrmOwnerId(req.getParameter("frmOwnerId"));
		this.myService.processLoadSpecies(myForm1);

		req.setAttribute("mySpeciesForm", myForm1);
		req.setAttribute("frmOwnerId", myForm1.getFrmOwnerId());
		System.out.println("Owner Id: " + myForm1.getFrmOwnerId());
		String action = req.getParameter("action");
		if (action.equals("admin")) {
			System.out.println("Owner Controller DO GET by admin");
			OwnerForm myForm = new OwnerForm();
			this.myService.processLoadOwners(myForm);
			req.setAttribute("action", action);
			req.setAttribute("myOwnerForm", myForm);
			RequestDispatcher rd = req.getRequestDispatcher("register_owner.jsp");
			rd.forward(req, resp);

		} else if (action.equals("owner")) {
			System.out.println("Owner Controller DO GET by owner");
			String frmOwnerId = req.getParameter("frmOwnerId");
			String frmOwnerPassword=req.getParameter("frmOwnerPassword");
			OwnerForm myForm = new OwnerForm();
			this.myService.processLoadOwnerById(myForm, frmOwnerId);

			req.setAttribute("action", action);
			req.setAttribute("myOwnerForm", myForm);
			req.setAttribute("frmOwnerId", frmOwnerId);
			req.setAttribute("frmOwnerPassword", frmOwnerPassword);
			System.out.println("owner id Trace : " + frmOwnerId);

			RequestDispatcher rd = req.getRequestDispatcher("register_owner.jsp");
			rd.forward(req, resp);
		} else if (action.equals("newMember")) {
			System.out.println("Owner Controller DO GET by new member");
			OwnerForm myForm = new OwnerForm();
			this.myService.processLoadOwners(myForm);
			req.setAttribute("action", action);
			req.setAttribute("myOwnerForm", myForm);

			RequestDispatcher rd = req.getRequestDispatcher("register_owner.jsp");
			rd.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Owner Controller DO POST");
		// save owner
		OwnerForm myForm = new OwnerForm();

		String id = req.getParameter("frmOwnerId");

		myForm.setFrmId(id);
		System.out.println("Controller trace: id =" + id);
		myForm.setFrmName(req.getParameter("frmName"));
		myForm.setFrmPhone(req.getParameter("frmPhone"));
		myForm.setFrmEmail(req.getParameter("frmEmail"));
		myForm.setFrmAddress(req.getParameter("frmAddress"));
		this.myService.processSaveOwner(myForm);
		req.setAttribute("frmOwnerForm", myForm);
		System.out.println("Owner Id TRACE: " + myForm.getFrmId());

		// UserLogin (pet_login)
		UserLoginForm myForm1 = new UserLoginForm();
		String password = req.getParameter("frmPassword");
		myForm1.setFrmId(id);
		myForm1.setFrmPassword(password);
		this.myService.processSaveUserLogin(myForm1);

		// save pet
		PetForm myForm2 = new PetForm();
		String speciesId = req.getParameter("frmSpeciesId");
		String petId = req.getParameter("frmId");
		String name = req.getParameter("frmPetName");
		String sex = req.getParameter("frmSex");
		String bDate = req.getParameter("frmBirthDate");
		String dDate = req.getParameter("frmDeathDate");

		myForm2.setFrmSpeciesId(Integer.parseInt(speciesId));
		myForm2.setFrmOwnerId(id);
		myForm2.setFrmId(petId);
		myForm2.setFrmName(name);
		myForm2.setFrmSex(sex);
		myForm2.setFrmBirthDate(DateUtil.convertS2D(bDate));
		myForm2.setFrmDeathDate(DateUtil.convertS2D(dDate));

		System.out.println("Species Id : " + speciesId);
		System.out.println("Owner Id : " + id);
		System.out.println("Pet Id : " + petId);
		System.out.println("Pet Name : " + name);
		System.out.println("Pet Sex : " + sex);
		System.out.println("Pet bDate : " + bDate);
		System.out.println("Pet dDate : " + dDate);

		this.myService.processSavePet(myForm2);
		req.setAttribute("myPetForm", myForm2);

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
