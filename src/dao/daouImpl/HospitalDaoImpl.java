package dao.daouImpl;

import dao.HospitalDao;
import dataBase.DataBase;
import models.Hospital;
import models.Patient;

import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {
    @Override
    public void addHospital(Hospital hospital) {
        DataBase.hospitals.add(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for(Hospital hospital:DataBase.hospitals){
            if(hospital.getId()==id){
                return hospital;
            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return DataBase.hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for(Hospital hospital:DataBase.hospitals){
            if(hospital.getId()==id){
                return hospital.getPatients();
            }
        }
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        for(Hospital hospital:DataBase.hospitals){
            if(hospital.getId()==id){
                DataBase.hospitals.remove(hospital);
                return "success";
            }
        }
        return "Invalid";
    }

    @Override
    public Hospital getHospitalByAddress(String address) {
        for(Hospital hospital:DataBase.hospitals){
            if(hospital.getAddress().equalsIgnoreCase(address)){
                return hospital;
            }
        }
        return null;
    }
}
