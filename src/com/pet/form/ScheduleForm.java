package com.pet.form;

import java.util.Date;
import java.util.List;

import com.pet.model.Doctor;
import com.pet.model.Schedule;
import com.pet.model.Schedule.Day;

public class ScheduleForm {
	private Integer frmScheduleId;
	private String frmDayName;
	private String frmStartTime;
	private String frmEndTime;
	
	private String frmDoctorId;
	private Doctor frmDoctor;
	private List<Schedule> frmScheduleList;
	
	public String getFrmDayName() {
		return frmDayName;
	}
	public void setFrmDayName(String frmDayName) {
		this.frmDayName = frmDayName;
	}
	public String getFrmDoctorId() {
		return frmDoctorId;
	}
	public void setFrmDoctorId(String frmDoctorId) {
		this.frmDoctorId = frmDoctorId;
	}
	public Integer getFrmScheduleId() {
		return frmScheduleId;
	}
	public void setFrmScheduleId(Integer frmScheduleId) {
		this.frmScheduleId = frmScheduleId;
	}

	public String getFrmStartTime() {
		return frmStartTime;
	}
	public void setFrmStartTime(String string) {
		this.frmStartTime = string;
	}
	public String getFrmEndTime() {
		return frmEndTime;
	}
	public void setFrmEndTime(String frmEndTime) {
		this.frmEndTime = frmEndTime;
	}
	public Doctor getFrmDoctor() {
		return frmDoctor;
	}
	public void setFrmDoctor(Doctor frmDoctor) {
		this.frmDoctor = frmDoctor;
	}
	public List<Schedule> getFrmScheduleList() {
		return frmScheduleList;
	}
	public void setFrmScheduleList(List<Schedule> frmScheduleList) {
		this.frmScheduleList = frmScheduleList;
	}
	
}
