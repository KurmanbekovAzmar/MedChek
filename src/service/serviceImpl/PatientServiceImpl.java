package service.serviceImpl;

import dao.GenericDao;
import dao.PatientDao;
import dao.daouImpl.DepartmentDaoImpl;
import dao.daouImpl.PatientDaoImpl;
import models.Patient;
import service.GenericService;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService, GenericService<Patient> {
    PatientDao patientDao = new PatientDaoImpl();
    GenericDao genericDao = new PatientDaoImpl();

    @Override
    public String add(Long hospitalId, Patient patient) {
        return genericDao.add(hospitalId,patient);
    }

    @Override
    public void removeById(Long id) {
        genericDao.removeById(id);
    }

    @Override
    public String updateById(Long id) {
        return genericDao.updateById(id);
    }

    @Override
    public String addPatientsToHospital(Long id, Patient patient) {
        return patientDao.addPatientsToHospital(id,patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public String  getPatientByAge(Long id,int patientAge) {
        return patientDao.getPatientByAge(id, patientAge);
    }

    @Override
    public void sortPatientsByAge(Long id,String ascOrDesc) {
        patientDao.sortPatientsByAge(id, ascOrDesc);
    }
}
