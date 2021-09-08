package com.pet.model;

import java.util.List;

public class Doctor {
	private String doctorId;
	private String doctorName;
	private String doctorRank;
	
	private List<Schedule> drScheduleList;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String doctorId, String doctorName, String doctorRank, List<Schedule> drScheduleList) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorRank = doctorRank;
		this.drScheduleList = drScheduleList;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorRank() {
		return doctorRank;
	}
	public void setDoctorRank(String doctorRank) {
		this.doctorRank = doctorRank;
	}
	public List<Schedule> getDrScheduleList() {
		return drScheduleList;
	}
	public void setDrScheduleList(List<Schedule> drScheduleList) {
		this.drScheduleList = drScheduleList;
	}
	
}
