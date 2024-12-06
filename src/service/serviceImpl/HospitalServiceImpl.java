package service.serviceImpl;

import dao.HospitalDao;
import dao.daouImpl.HospitalDaoImpl;
import models.Hospital;
import models.Patient;
import service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    HospitalDao hospitalDao = new HospitalDaoImpl();

    @Override
    public void addHospital(Hospital hospital) {
        hospitalDao.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return hospitalDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id) ;
    }

    @Override
    public String deleteHospitalById(Long id) {
        return hospitalDao.deleteHospitalById(id);
    }

    @Override
    public Hospital getAllHospitalByAddress(String address) {
        return hospitalDao.getHospitalByAddress(address);
    }
}
