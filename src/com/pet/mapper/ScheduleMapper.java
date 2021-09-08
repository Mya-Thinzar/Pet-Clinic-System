package com.pet.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pet.model.Schedule;

public interface ScheduleMapper {
	public void insertSchedule(Schedule myS);

	
	@Select("select d.*,s.* "
			+"from doctor d,doctor_schedule s "
			+"where d.doctor_id=#{doctorId} "
			+"and s.doctor_id=d.doctor_id")
	@Results({
			@Result(column="schedule_id",property="scheduleId"),
			@Result(column="day_name",property="dayName"),
			@Result(column="start_time",property="startTime"),
			@Result(column="end_time",property="endTime"),	
			@Result(column="doctor_id",property="doctorId"),
			@Result(column="doctor_id",property="doctor.doctorId"),
			@Result(column="doctor_name",property="doctor.doctorName"),
			@Result(column="doctor_rank",property="doctor.doctorRank")
	})
	public List<Schedule> getAllScheduleByDoctorId(String did);

	
	@Select("select * "
            +"from doctor_schedule "
            +"where doctor_id=#{doctorId} "
            +"and schedule_id=#{scheduleId}")
	@Results({
		@Result(column="schedule_id",property="scheduleId"),
		@Result(column="day_name",property="dayName"),
		@Result(column="start_time",property="startTime"),
		@Result(column="end_time",property="endTime"),	
		@Result(column="doctor_id",property="doctorId")
	})
	public List<Schedule> getScheduleById(@Param("doctorId") String did,@Param("scheduleId")  Integer sid);


	public void updateSchedule(Schedule myS);

	@Select("select d.*,s.* "
			+"from doctor d,doctor_schedule s "
			+"where s.doctor_id=d.doctor_id "
			+ "and s.day_name=substring((upper(dayname(curdate()+3))),1,3)")
	@Results({
			@Result(column="schedule_id",property="scheduleId"),
			@Result(column="day_name",property="dayName"),
			@Result(column="start_time",property="startTime"),
			@Result(column="end_time",property="endTime"),	
			@Result(column="doctor_id",property="doctorId"),
			@Result(column="doctor_id",property="doctor.doctorId"),
			@Result(column="doctor_name",property="doctor.doctorName"),
			@Result(column="doctor_rank",property="doctor.doctorRank")
	})
	public List<Schedule> getScheduleForApp();
}