package com.pet.service;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.dao.AdminDao;
import com.pet.dao.AppointmentDao;
import com.pet.dao.CardDao;
import com.pet.dao.DoctorDao;
import com.pet.dao.DrugTypeDao;
import com.pet.dao.OwnerDao;
import com.pet.dao.PaymentDao;
import com.pet.dao.PetDao;
import com.pet.dao.PetDrugDao;
import com.pet.dao.ScheduleDao;
import com.pet.dao.SpeciesDao;
import com.pet.dao.UserLoginDao;
import com.pet.form.AppointmentForm;
import com.pet.form.CardForm;
import com.pet.form.DoctorForm;
import com.pet.form.DrugTypeForm;
import com.pet.form.OwnerForm;
import com.pet.form.PaymentForm;
import com.pet.form.PetDrugForm;
import com.pet.form.PetForm;
import com.pet.form.ScheduleForm;
import com.pet.form.SpeciesForm;
import com.pet.form.UserLoginForm;
import com.pet.model.Appointment;
import com.pet.model.Card;
import com.pet.model.Doctor;
import com.pet.model.DrugType;
import com.pet.model.Owner;
import com.pet.model.Payment;
import com.pet.model.Payment.Status;
import com.pet.model.Pet;
import com.pet.model.PetDrug;
import com.pet.model.PetUserLogin;
import com.pet.model.ProcAppDate;
import com.pet.model.ProcLastInsertId;
import com.pet.model.Schedule;
import com.pet.model.Species;
import com.pet.model.DrugType.Type;
import com.pet.util.DateUtil;
import com.pet.model.Schedule.Day;

public class GeneralService {
	private UserLoginDao myUserLoginDao;
	public PetUserLogin myUserLogin;
	private DoctorDao myDoctorDao;
	private OwnerDao myOwnerDao;
	private SpeciesDao mySpeciesDao;
	private PetDao myPetDao;
	public AdminDao myAdminDao;
	private ScheduleDao mySchDao;
	private AppointmentDao myAppDao;
	private PaymentDao myPayDao;
	private CardDao myCardDao;
	private DrugTypeDao myDrugTypeDao;
	private PetDrugDao myPetDrugDao;
	
	public GeneralService(SqlSessionFactory sf){
		this.myUserLoginDao=new UserLoginDao(sf);
		this.myAdminDao=new AdminDao(sf);
		this.myDoctorDao=new DoctorDao(sf);
		this.myOwnerDao=new OwnerDao(sf);
		this.myPetDao=new PetDao(sf);
		this.mySpeciesDao=new SpeciesDao(sf);
		this.mySchDao=new ScheduleDao(sf);
		this.myAppDao=new AppointmentDao(sf);
		this.myPayDao=new PaymentDao(sf);
		this.myCardDao=new CardDao(sf);
		this.myDrugTypeDao=new DrugTypeDao(sf);
		this.myPetDrugDao=new PetDrugDao(sf);
	}
	
	public void processUpdateDoctor(DoctorForm myForm) {
		Doctor myD=new Doctor();
		String did=myForm.getFrmId();
		String name=myForm.getFrmName();
		String rank=myForm.getFrmRank();
		myD.setDoctorId(did);
		myD.setDoctorName(name);
		myD.setDoctorRank(rank);
		this.myDoctorDao.updateDoctor(myD);
		
	}
	public void processUpdatePet(PetForm myForm){
		Pet myP=new Pet();
		Integer sid=myForm.getFrmSpeciesId();
		String oid=myForm.getFrmOwnerId();
		String pid=myForm.getFrmId();
		String name=myForm.getFrmName();
		String sex=myForm.getFrmSex();
		Date bDate=myForm.getFrmBirthDate();
		Date dDate=myForm.getFrmDeathDate();
		System.out.println("ID TRACE IN SERVICE TRACE :"+oid+":"+sid+":"+pid);
		myP.setPetId(pid);
		myP.setPetName(name);
		myP.setPetSex(sex);
		myP.setPetBirth(bDate);
		myP.setPetDeath(dDate);
		myP.setSpeciesId(sid);
		myP.setOwnerId(oid);
		this.myPetDao.updatePet(myP);
	}
	
	public void processUpdateSpecies(SpeciesForm myForm){
		Species myS=new Species();
		Integer id=Integer.parseInt(myForm.getFrmSpeciesId());
		System.out.println("SPECIES ID IN SERVICE TRACE :"+id);
		myS.setSpeciesId(id);
		myS.setSpeciesName(myForm.getFrmName());
		this.mySpeciesDao.updateSpecies(myS);
	}
	public void processLoadSpeciesById(SpeciesForm myForm,String sId){
		myForm.setFrmSpeciesList(this.mySpeciesDao.getSpeciesById(sId));
		
	}
	public void processUpdateOwner(OwnerForm myForm){
		Owner myOwner=new Owner();
		myOwner.setOwnerId(myForm.getFrmId());
		myOwner.setOwnerName(myForm.getFrmName());	
		myOwner.setOwnerPh(myForm.getFrmPhone());
		myOwner.setOwnerEmail(myForm.getFrmEmail());
		myOwner.setOwnerAdd(myForm.getFrmAddress());
		this.myOwnerDao.updateOwner(myOwner);
		
	}
	public void processUpdatePassword(UserLoginForm myForm){
		PetUserLogin myUser=new PetUserLogin();
		myUser.setLoginId(myForm.getFrmId());
		myUser.setloginPassword(myForm.getFrmPassword());
		System.out.println("ID IN SERVICE TRACE :"+myUser.getLoginId());
		System.out.println("UPDATE PASSWORD IN SERVICE TRACE :"+myUser.getloginPassword());
		this.myAdminDao.updatePassword(myUser);
	}
	public void processUserLogin(UserLoginForm myForm){
		String id=myForm.getFrmId();
		String password=myForm.getFrmPassword();
		System.out.println("SERVICE TRACE1: "+id+","+password);
		myUserLogin=this.myUserLoginDao.checkLogin(id, password);
	}
	
	public void processSaveUserLogin(UserLoginForm myForm){
		PetUserLogin myAdmin=new PetUserLogin();
		
		String id=myForm.getFrmId();
		String password=myForm.getFrmPassword();
		
		myAdmin.setLoginId(id);
		myAdmin.setloginPassword(password);
		
		System.out.println("Service Trace 1: "
				+myAdmin.getLoginId()+","+myAdmin.getloginPassword());
		System.out.println("SERVICE TRACE2 : "+id+","+password);
		
		this.myAdminDao.saveAdmin(myAdmin);
		
		System.out.println("SAVE SUCCESS!!!!!");
	}
	
	public void processSaveDoctor(DoctorForm myForm){
		Doctor d=new Doctor();
		
		String id=myForm.getFrmId();
		String name=myForm.getFrmName();
		String rank=myForm.getFrmRank();
		
		d.setDoctorId(id);
		d.setDoctorName(name);
		d.setDoctorRank(rank);
		
		this.myDoctorDao.saveDoctor(d);
	}
	
	public void processSaveOwner(OwnerForm myForm){
		Owner o=new Owner();
		
		String id=myForm.getFrmId();
		String name=myForm.getFrmName();
		String ph=myForm.getFrmPhone();
		String email=myForm.getFrmEmail();
		String address=myForm.getFrmAddress();
		
		o.setOwnerId(id);
		o.setOwnerName(name);
		o.setOwnerPh(ph);
		o.setOwnerEmail(email);
		o.setOwnerAdd(address);
		
		this.myOwnerDao.saveOwner(o);
	}
	
	public void processSaveSpecies(SpeciesForm myForm){
		Species s=new Species();
		
		String name=myForm.getFrmName();
		s.setSpeciesName(name);
		
		this.mySpeciesDao.saveSpecies(s);
	}
	
	public void processSavePet(PetForm myForm) {
		Pet p = new Pet();
		p.setPetId(myForm.getFrmId());
		p.setPetName(myForm.getFrmName());;
		p.setPetSex(myForm.getFrmSex());
		p.setPetBirth(myForm.getFrmBirthDate());
		p.setPetDeath(myForm.getFrmDeathDate());
		p.setOwnerId(myForm.getFrmOwnerId());
		p.setSpeciesId(myForm.getFrmSpeciesId());
		this.myPetDao.savePet(p);
		
	}
	
	public void processLoadDoctors(DoctorForm myForm){
		myForm.setFrmDoctorList(this.myDoctorDao.getAll());
	}
	
	public void processLoadOwners(OwnerForm myForm){
		myForm.setFrmOwnerList(this.myOwnerDao.getAll());
	}
	
	public void processLoadOwnerById(OwnerForm myForm,String ownerId){
		myForm.setFrmOwnerList(this.myOwnerDao.getOwnerbyId(ownerId));
		
	}
	public void processLoadSpecies(SpeciesForm myForm){
		myForm.setFrmSpeciesList(this.mySpeciesDao.getAll());;
	}
	public void processLoadPets(PetForm myForm){
		String ownerId=myForm.getFrmOwnerId();
		myForm.setFrmPetList(this.myPetDao.getAllPetsByOwnerIdAndSpeciesId(ownerId));
	}
	
	public void processLoadPetById(PetForm myForm){
		String ownerId=myForm.getFrmOwnerId();
		Integer speciesId=myForm.getFrmSpeciesId();
		String petId=myForm.getFrmId();
		myForm.setFrmPetList(this.myPetDao.getPetById(ownerId, speciesId, petId));
	}

	public void processLoadDoctorById(DoctorForm myForm, String frmDoctorId) {
		myForm.setFrmDoctorList(this.myDoctorDao.getDoctorById(frmDoctorId));
		
	}

	public void processSaveSchedule(ScheduleForm myForm) {
		Schedule s=new Schedule();
		s.setDoctorId(myForm.getFrmDoctorId());
		s.setDayName(Day.valueOf(myForm.getFrmDayName()));
		String sTime=myForm.getFrmStartTime();
		String eTime=myForm.getFrmEndTime();
		
		System.out.println("START TIME IN SERVICE TRACE : "+sTime);
		System.out.println("END TIME IN SERVICE TRACE : "+eTime);

		s.setStartTime(sTime);
		s.setEndTime(eTime);
		this.mySchDao.saveSchedule(s);	
	}

	public void processLoadSchedule(ScheduleForm myForm) {
		String did=myForm.getFrmDoctorId();
		myForm.setFrmScheduleList(this.mySchDao.getAllScheduleByDoctorId(did));	
	}

	public void processLoadScheduleById(ScheduleForm myForm) {
		String did=myForm.getFrmDoctorId();
		Integer sid=myForm.getFrmScheduleId();
		myForm.setFrmScheduleList(this.mySchDao.getScheduleById(did, sid));		
	}

	public void processUpdateSchedule(ScheduleForm myForm) {
		Schedule s=new Schedule();
		s.setDoctorId(myForm.getFrmDoctorId());
		s.setScheduleId(myForm.getFrmScheduleId());
		s.setDayName(Day.valueOf(myForm.getFrmDayName()));
		String sTime=myForm.getFrmStartTime();
		String eTime=myForm.getFrmEndTime();
		
		System.out.println("START TIME IN SERVICE TRACE : "+sTime);
		System.out.println("END TIME IN SERVICE TRACE : "+eTime);

		s.setStartTime(sTime);
		s.setEndTime(eTime);
		this.mySchDao.updateSchedule(s);		
		
	}

	public void processLoadScheduleForApp(ScheduleForm myForm) {
		myForm.setFrmScheduleList(this.mySchDao.getScheduleForApp());				
	}

	public void processDate(ProcAppDate myd){
		myd.setCurDate(this.mySchDao.getCurDate());
	}

	public void processSaveAppointment(AppointmentForm myForm) {
		Appointment ap=new Appointment();
		ap.setOwnerId(myForm.getFrmOwnerId());
		ap.setAppDate(DateUtil.convertS2D(myForm.getFrmAppDate()));
		ap.setAppTime(myForm.getFrmAppTime());
		this.myAppDao.saveAppointment(ap);	
	}

	public void processLoadAppointment(AppointmentForm myForm) {
		myForm.setFrmAppList(this.myAppDao.getAllAppointments());
	}

	public void processSavePayment(PaymentForm myForm) {
		Payment p=new Payment();
		p.setVoucherNo(myForm.getFrmVoucherNo());
		p.setPaymentDate(DateUtil.convertS2D(myForm.getFrmPaymentDate()));
		p.setPaymentAmt(Integer.parseInt(myForm.getFrmPaymentAmt()));
		p.setPaymentStatus(Status.valueOf(myForm.getFrmPaymentStatus()));
		this.myPayDao.savePayment(p);
	}

	public void processLoadPayment(PaymentForm myForm) {
		myForm.setFrmPaymentList(this.myPayDao.getAllPayments());
	}

	public void processSaveCard(CardForm myForm) {
		Card c=new Card();
		c.setCardNumber(myForm.getFrmCardNumber());
		c.setVoucherNo(myForm.getFrmVoucherNo());
		this.myCardDao.saveCard(c);		
	}

	public void processSaveDrugType(DrugTypeForm myForm) {
		DrugType dt=new DrugType();
		dt.setDrugName(myForm.getFrmDrugName());
		dt.setDrugDuration(Integer.parseInt(myForm.getFrmDrugDuration()));
		dt.setDrugDurationType(Type.valueOf(myForm.getFrmDrugDurationType()));
		this.myDrugTypeDao.saveDrugType(dt);
	}

	public void processLoadPetsForTreatment(PetForm myForm) {
		myForm.setFrmPetList(this.myPetDao.getAllPetsForTreatment());
	}

	public void processSaveAndGetId(ProcLastInsertId a, DrugTypeForm myForm) {
		//DrugType dt=new DrugType();
		//dt.setDrugName(myForm.getFrmDrugName());
		//dt.setDrugDuration(Integer.parseInt(myForm.getFrmDrugDuration()));
		//dt.setDrugDurationType(Type.valueOf(myForm.getFrmDrugDurationType()));
		//ProcLastInsertId id=new ProcLastInsertId();
		a.setLastId(this.myDrugTypeDao.getLastInsertId(myForm.getFrmDrugName(),
				Integer.parseInt(myForm.getFrmDrugDuration()),myForm.getFrmDrugDurationType()));	
		System.out.println("DRUG ID IN SERVICE: "+a.getLastId());
	}

	public void processLoadDrugType(DrugTypeForm myForm) {
		myForm.setFrmDrugTypeList(this.myDrugTypeDao.getAll());
	}
	
	public void processLoadPetByPetId(PetForm myForm, String frmPetId) {
		myForm.setFrmPetList(this.myPetDao.getPetbyPetId(frmPetId));
		
	}

	public void processSavePetDrug(PetDrugForm myForm) {
		PetDrug p = new PetDrug();
		p.setPetId(myForm.getFrmPetId());
		p.setDoctorId(myForm.getFrmDoctorId());
		p.setDrugDate(myForm.getFrmDrugDate());
		p.setDrugId(myForm.getFrmDrugId());
		p.setDrugNextDate(myForm.getFrmDrugNextDate());
		p.setDrugDesc(myForm.getFrmDrugDesc());

		this.myPetDrugDao.savePetDrug(p);		
	}

	public void processLoadDrugTypeById(DrugTypeForm myForm) {
		Integer id=myForm.getFrmDrugId();
		myForm.setFrmDrugTypeList(this.myDrugTypeDao.getDrugTypeById(id));		
	}

	public void processLoadPetHistory(PetDrugForm myForm) {
		myForm.setFrmPetDrugList(this.myPetDrugDao.getPetHistory());
	}

	public void processLoadDrugTime(PetDrugForm myForm) {
		String ownerId=myForm.getFrmOwnerId();
		myForm.setFrmPetDrugList(this.myPetDrugDao.getDrugTime(ownerId));		
	}
}
