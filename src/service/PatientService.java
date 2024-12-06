package service;

import models.Patient;

import java.util.List;
import java.util.Map;

public interface PatientService {
    String addPatientsToHospital(Long id,Patient patient);
    Patient getPatientById(Long id);
    String getPatientByAge(Long id,int patientAge);
    void sortPatientsByAge(Long id,String ascOrDesc);
}
