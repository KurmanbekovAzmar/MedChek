package dao;

import models.Patient;

public interface PatientDao {
    String addPatientsToHospital(Long id, Patient patients);
    Patient getPatientById(Long patientId);
    String getPatientByAge(Long id,int patientAge);
    void sortPatientsByAge(Long id,String ascOrDesc);
}
