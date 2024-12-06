package dao;

import models.Hospital;
import models.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalDao {
    void addHospital(Hospital hospital);
    Hospital findHospitalById(Long id);
    List<Hospital> getAllHospital();
    List<Patient> getAllPatientFromHospital(Long id);
    String deleteHospitalById(Long id);
    Hospital getHospitalByAddress(String address);
}
