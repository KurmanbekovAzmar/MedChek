package dao;

import models.Doctor;

import java.util.List;

public interface DoctorDao {
    String assignDoctorToDepartment(Long hospitalid,Long departmentId,Long doctorsId);
    List<Doctor> getAllDoctorsByHospitalId(Long id);
    List<Doctor> getAllDoctorsByDepartmentId(Long id,Long departmentId);
    Doctor findDoctorById(Long id,Long doctorId);

}
