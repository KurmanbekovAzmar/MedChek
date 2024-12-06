import dao.DepartmentDao;
import dao.daouImpl.DepartmentDaoImpl;
import enums.Gender;
import genericId.GenericId;
import models.Department;
import models.Hospital;
import models.Patient;
import service.DepartmentService;
import service.DoctorService;
import service.HospitalService;
import service.PatientService;
import service.serviceImpl.DepartmentSeviceImpl;
import service.serviceImpl.DoctorServiceImpl;
import service.serviceImpl.HospitalServiceImpl;
import service.serviceImpl.PatientServiceImpl;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();
        DepartmentSeviceImpl departmentService = new DepartmentSeviceImpl();
        for(;true;){
            System.out.println("""
                    1-Add hospital
                    2-Add patient to hospital
                    3-Add department to hospital
                    4-Add doctor to hospital
                    5-Delete patient by id
                    6-Delete doctor by id
                    7-Delete department by id
                    8-Delete hospital by id
                    9-Update patient by id
                    10-Update department by id
                    11-Update doctor by id
                    12-Get all department by hospital id
                    13-Find department by name
                    14-Assign doctor to department by id
                    15-Get all doctors by hospital id
                    16-Get all doctor by department id
                    17-find doctor by id
                    18-Find hospital by id
                    19-Get all hospital
                    20-Get all patient by hospital id
                    21-Get all hospitals by address
                    22-Get patient by id
                    23-Get patient by age
                    24-Sort patient by age
                    """);
            int i = scanner1.nextInt();
            switch (i){
                case 1->{
                    System.out.println("Write hospital name:");
                    String name = scanner.nextLine();
                    System.out.println("Write hospital address:");
                    scanner.nextLine();
                    String address = scanner1.nextLine();
                    hospitalService.addHospital(new Hospital(GenericId.genHospitalId(),name,address));

                }
                case 2->{
                    System.out.println("Write hospital id:");
                    Long id = scanner.nextLong();
                    System.out.println("Write patient name:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("write patient last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Write patient age:");
                    int age = scanner.nextInt();
                    System.out.println("1-male , 2-female");
                    int gender = scanner.nextInt();
                    Gender gender1 = null;
                    if(gender==1){
                        gender1=Gender.MALE;
                    } else if (gender==2) {
                        gender1 = Gender.FEMALE;
                    }
                    patientService.addPatientsToHospital(id,new Patient(GenericId.genPatientId(),name,lastName,age,gender1));
                }
                case 3->{
                    System.out.println("Write hospital id:");
                    long id = scanner.nextLong();
                    System.out.println("Write department name");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    departmentService.add(id,new Department(GenericId.genDepartmentId(),name));
                }
                case 4->{
                    System.out.println("Write hospital id:");
                    Long id = scanner.nextLong();
                    System.out.println("Write doctor name:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("write doctor last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Write doctor expirience age");
                    int age = scanner.nextInt();
                    System.out.println("1-Male 2-Female");
                    int gender = scanner.nextInt();
                    Gender gender1 = null;
                    if(gender==1){
                        gender1=Gender.MALE;
                    } else if (gender==2) {
                        gender1 = Gender.FEMALE;
                    }
                    patientService.addPatientsToHospital(id,new Patient(GenericId.genPatientId(),name,lastName,age,gender1));

                }
                case 5->{
                    System.out.println("Write patient id:");
                    long id = scanner.nextLong();
                    patientService.removeById(id);
                }
                case 6->{
                    System.out.println("Write doctor id:");
                    Long id = scanner.nextLong();
                    doctorService.removeById(id);
                }
                case 7->{
                    System.out.println("Write department id:");
                    Long id = scanner.nextLong();
                    departmentService.removeById(id);
                }
                case 8 ->{
                    System.out.println("Write hospital id:");
                    long id = scanner.nextLong();
                    System.out.println(hospitalService.deleteHospitalById(id));
                }
                case 9->{
                    System.out.println("Write patient id:");
                    long patientId = scanner.nextLong();
                    System.out.println(patientService.updateById(patientId));
                }
                case 10->{
                    System.out.println("Write department id:");
                    long departmentId = scanner.nextLong();
                    System.out.println(departmentService.updateById(departmentId));
                }
                case 11->{
                    System.out.println("Write doctor id:");
                    long id = scanner.nextLong();
                    System.out.println(doctorService.updateById(id));
                }
                case 12->{
                    System.out.println("Write hospital id:");
                    Long id = scanner.nextLong();
                    System.out.println(departmentService.getAllDepartmentByHospital(id));
                }
                case 13->{
                    System.out.println("Write department name:");
                    String name = scanner.nextLine();
                    System.out.println(departmentService.findDepartmentByName(name));
                }
                case 14->{
                    System.out.println("Write hospital id:");
                    long hosId = scanner.nextLong();
                    System.out.println("Write doctor id:");
                    long id = scanner.nextLong();
                    System.out.println("Write department id:");
                    long depId = scanner.nextLong();
                    System.out.println(doctorService.assignDoctorToDepartment(hosId, depId, id));
                }
                case 15->{
                    System.out.println("Write hospital id:");
                    long id = scanner.nextLong();
                    System.out.println(doctorService.getAllDoctorsByHospitalId(id));
                }
                case 16->{
                    System.out.println("Write hospital id:");
                    long hosId = scanner.nextLong();
                    System.out.println("Write department id:");
                    long depId = scanner.nextLong();
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(hosId, depId));
                }
                case 17->{
                    System.out.println("Write doctor id:");
                    long id = scanner.nextLong();
                    System.out.println("Write doctor id");
                    long docId = scanner.nextLong();
                    System.out.println(doctorService.findDoctorById(id,docId));
                }
                case 18->{
                    System.out.println("Write hospital id:");
                    long id = scanner.nextLong();
                    System.out.println(hospitalService.findHospitalById(id));
                }
                case 19->{
                    System.out.println(hospitalService.getAllHospital());
                }
                case 20->{
                    System.out.println("Write hospital id:");
                    long id = scanner.nextLong();
                    System.out.println(hospitalService.getAllPatientFromHospital(id));
                }
                case 21->{
                    System.out.println("Write hospital address:");
                    String address = scanner1.nextLine();
                    System.out.println(hospitalService.getAllHospitalByAddress(address));
                }
                case 22->{
                    System.out.println("White patient id:");
                    long id = scanner.nextLong();
                    System.out.println(patientService.getPatientById(id));
                }
                case 23->{
                    System.out.println("Write hospital id:");
                    long id = scanner.nextLong();
                    System.out.println("Write patient age:");
                    int age = scanner.nextInt();
                    System.out.println(patientService.getPatientByAge(id,age));
                }
                case 24->{
                    System.out.println("Write hospital id:");
                    long id = scanner.nextLong();
                    System.out.println("Asc or Desc");
                    String ascOrDesc = scanner.nextLine();
                    patientService.sortPatientsByAge(id,ascOrDesc);
                }
            }
        }
    }
}
