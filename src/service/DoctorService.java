package service;

import models.Doctor;

import java.util.List;

public interface DoctorService {
    String assignDoctorToDepartment(Long hospitalId,Long departmentId,Long doctorsId);
    List<Doctor> getAllDoctorsByHospitalId(Long id);
    List<Doctor> getAllDoctorsByDepartmentId(Long id,Long departmentId);
    Doctor findDoctorById(Long id,Long doctorId);


}
