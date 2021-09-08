package com.pet.model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;


public class Schedule {
	private Integer scheduleId;
	public enum Day{MON,TUE,WED,THU,FRI,SAT,SUN} ;
	private Day dayName;
	private String startTime;
	private String endTime;
	
	private Doctor doctor;
	private String doctorId;
	
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Schedule(Integer scheduleId, Day dayName, String startTime, String endTime, Doctor doctor,
			String doctorId) {
		super();
		this.scheduleId = scheduleId;
		this.dayName = dayName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.doctor = doctor;
		this.doctorId = doctorId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Day getDayName() {
		return dayName;
	}
	public void setDayName(Day dayName) {
		this.dayName = dayName;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
}
