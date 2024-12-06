package dao.daouImpl;

import dao.DepartmentDao;
import dao.GenericDao;
import dataBase.DataBase;
import models.Department;
import models.Hospital;

import java.util.List;
import java.util.Scanner;

public class DepartmentDaoImpl implements DepartmentDao, GenericDao<Department> {
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for(Hospital hospital: DataBase.hospitals){
            if(hospital.getId()==id){
                return hospital.getDepartments();
            }
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for(Hospital hospital:DataBase.hospitals){
            for(Department department: hospital.getDepartments()){
                if(department.getDepartmentName().equalsIgnoreCase(name)){
                    return department;
                }
            }
        }
        return null;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        for(Hospital hospital:DataBase.hospitals){
            if(hospital.getId()==hospitalId){
                hospital.getDepartments().add(department);
                return "Success";
            }
        }
        return "Invalid";
    }

    @Override
    public void removeById(Long objectId) {
        for(Hospital hospital:DataBase.hospitals) {
            for (Department department1 : hospital.getDepartments()) {
                if (department1.getId() == objectId) {
                    hospital.getDepartments().remove(department1);
                    System.out.println("Success");
                    break;

                } else {
                    System.out.println("Invalid");
                }
            }
        }
        }

    @Override
    public String updateById(Long id) {
        for(Hospital hospital:DataBase.hospitals){
            for(Department department:hospital.getDepartments()){
                if(department.getId()==id){
                    hospital.getDepartments().remove(department);
                    return "Success";
                }
            }
        }
        return "Invalid";
    }
}

