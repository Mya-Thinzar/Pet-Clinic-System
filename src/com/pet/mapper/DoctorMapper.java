package com.pet.mapper;
import java.util.List;
import com.pet.model.Doctor;

public interface DoctorMapper {
	public void insertDoctor(Doctor d);
	public List<Doctor> getAll();
	public List<Doctor> getDoctorById(String did);
	public void updateDoctor(Doctor myD);
}