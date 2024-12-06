package dao.daouImpl;

import dao.GenericDao;
import dao.PatientDao;
import dataBase.DataBase;
import models.Hospital;
import models.Patient;

import java.util.*;

public class PatientDaoImpl implements PatientDao, GenericDao<Patient> {

    @Override
    public String addPatientsToHospital(Long id, Patient patient1) {
        for (Hospital hospital : DataBase.hospitals) {
            if (hospital.getId() == id) {
                hospital.getPatients().add(patient1);
                return "Success";
            }
        }
        return "";
    }

    @Override
    public Patient getPatientById(Long patientId) {
        for (Hospital hospital : DataBase.hospitals) {

                for (Patient patient : hospital.getPatients()) {
                    if (patient.getId() == patientId) {
                        return patient;
                    }
                }
            }

        return null;
    }

    @Override
    public String getPatientByAge(Long id, int patientAge) {
        for (Hospital hospital : DataBase.hospitals) {
            if (hospital.getId() == id) {
                for (Patient patient : hospital.getPatients()) {
                    if (patient.getAge() == patientAge) {
                        System.out.println(patient);
                        return "Success";
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void sortPatientsByAge(Long id, String ascOrDesc) {
        for (Hospital hospital : DataBase.hospitals) {
            if (hospital.getId() == id) {
                System.out.println("0 - Выход\nAsc - По возрастанию\nDesc - По убыванию");
                if (ascOrDesc.equalsIgnoreCase("ASC")) {
                    hospital.getPatients().sort(Comparator.comparingInt(Patient::getAge));
                    System.out.println(hospital);
                    ;
                    break;
                } else if (ascOrDesc.equalsIgnoreCase("DESC")) {
                    hospital.getPatients().sort(Comparator.comparingInt(Patient::getAge).reversed());
                    System.out.println(hospital);
                    break;
                } else if (ascOrDesc.equalsIgnoreCase("0")) {
                    break;
                }
            }
        }
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        for (Hospital hospital : DataBase.hospitals) {
            if (hospital.getId() == hospitalId) {
                hospital.getPatients().add(patient);
            }
        }
        return "";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital:DataBase.hospitals){
            for(Patient patient:hospital.getPatients()){
                if(patient.getId().equals(id)){
                    hospital.getPatients().remove(patient);
                    break;
                }else{
                    System.out.println("Takoy patient net");
                }
            }
        }

    }

    @Override
    public String updateById(Long id) {
        Scanner scanner = new Scanner(System.in);
        for(Hospital hospital:DataBase.hospitals){
            for(Patient patient:hospital.getPatients()){
                if(patient.getId()==id){
                    System.out.println("Write new name:");
                    String name=scanner.nextLine();
                    System.out.println("Write new last name:");
                    String lastName = scanner.nextLine();
                    patient.setFirstName(name);
                    patient.setLastName(lastName);
                    return "успешно обнавлён";

                }
            }
        }
        return "не обнавлено";
    }
}
