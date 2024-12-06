package dao.daouImpl;

import dao.DoctorDao;
import dao.GenericDao;
import dataBase.DataBase;
import models.Department;
import models.Doctor;
import models.Hospital;

import java.util.List;
import java.util.Scanner;

public class DoctorDaoImpl implements DoctorDao, GenericDao<Doctor> {
    @Override
    public String assignDoctorToDepartment(Long hospitalId,Long departmentId,Long doctorId) {
        for(Hospital hospital: DataBase.hospitals){
            if(hospital.getId()==hospitalId){
                for(Doctor doctor1: hospital.getDoctors()){
                    if(doctor1.getId()==doctorId){
                        for(Department department:hospital.getDepartments()){
                            department.getDoctors().add(doctor1);
                        }

                    }
                }
            }
        }


        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for(Hospital hospital: DataBase.hospitals){
            if(hospital.getId()==id){
                return hospital.getDoctors();
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long hospitalId,Long departmentId) {
        for(Hospital hospital : DataBase.hospitals){
            if(hospital.getId()==hospitalId){
                for(Department department: hospital.getDepartments()){
                    if(department.getId()==departmentId){
                        return department.getDoctors();
                    }
                }
            }
        }
        return List.of();
    }

    @Override
    public Doctor findDoctorById(Long id,Long doctorId) {
        for(Hospital hospital:DataBase.hospitals){
            if(hospital.getId()==id){
                for(Doctor doctor:hospital.getDoctors()){
                    if(doctor.getId()==doctorId){
                        return doctor;

                    }
                }
            }
        }
        return null;
    }


    @Override
    public String add(Long hospitalId, Doctor doctor) {
        for(Hospital hospital:DataBase.hospitals){
            if(hospital.getId()==hospitalId){
                hospital.getDoctors().add(doctor);
                return "Success";
            }
        }
        return "Invalid";
    }

    @Override
    public void removeById(Long doctorId) {
        for(Hospital hospital:DataBase.hospitals){
                for(Doctor doctor1: hospital.getDoctors()){
                    if(doctor1.getId()==doctorId){
                        hospital.getDoctors().remove(doctor1);
                        System.out.println("Success");
                        break;
                    }else {
                        System.out.println("Invalid");
                        break;
                    }
                }

            }
        }

    @Override
    public String updateById(Long id) {
        Scanner scanner = new Scanner(System.in);
        for(Hospital hospital:DataBase.hospitals){
            for(Doctor doctor1:hospital.getDoctors()){
                if(doctor1.getId()==id){
                    System.out.println("Write new name:");
                    String name = scanner.nextLine();
                    doctor1.setFirstName(name);
                    System.out.println("Write new last name");
                    String lastName = scanner.nextLine();
                    doctor1.setLastName(lastName);
                    return "Success";
                }
            }
        }
        return "invalid";
    }


}



