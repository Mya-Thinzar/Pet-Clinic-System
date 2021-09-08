package com.pet.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pet.model.Appointment;
import com.pet.model.Schedule;

public interface AppointmentMapper {
	public void insertApp(Appointment ap);

	@Select("select o.*,a.* "
			+"from owner o,appointment a "
			+"where o.owner_id=a.owner_id")
	@Results({
			@Result(column="app_id",property="appId"),
			@Result(column="app_date",property="appDate"),
			@Result(column="app_time",property="appTime"),
			@Result(column="owner_id",property="owner.ownerId"),	
			@Result(column="owner_name",property="owner.ownerName"),
			@Result(column="owner_ph",property="owner.ownerPh"),
			@Result(column="owner_email",property="owner.ownerEmail"),
			@Result(column="owner_add",property="owner.ownerAdd")
	})
	public List<Appointment> getAllAppointments();
}