package service.serviceImpl;

import dao.DoctorDao;
import dao.GenericDao;
import dao.daouImpl.DoctorDaoImpl;
import models.Doctor;
import service.DoctorService;
import service.GenericService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {
    DoctorDao doctorDao = new DoctorDaoImpl();
    GenericDao<Doctor> genericDao = new DoctorDaoImpl();


    @Override
    public String assignDoctorToDepartment(Long hospitalid, Long departmentId, Long doctorsId) {
        return doctorDao.assignDoctorToDepartment(hospitalid, departmentId, doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id, Long departmentId) {
        return doctorDao.getAllDoctorsByDepartmentId(id,departmentId);
    }

    @Override
    public Doctor findDoctorById(Long id, Long doctorId) {
        return doctorDao.findDoctorById(id,doctorId);
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        return genericDao.add(hospitalId,doctor);
    }

    @Override
    public void removeById(Long id) {
        genericDao.removeById(id);
    }

    @Override
    public String updateById(Long id) {
        return genericDao.updateById(id);
    }
}
