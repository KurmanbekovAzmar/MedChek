package genericId;

public class GenericId {
    private static Long hospitalId = 0L;
    private static Long patientId = 0L;
    private static Long doctorId = 0L;
    private static Long departmentId = 0L;

    public static Long genHospitalId(){
        return ++hospitalId;
    }
    public static Long genPatientId(){
        return ++patientId;
    }
    public static Long genDoctorId(){
        return ++doctorId;
    }
    public static Long genDepartmentId(){
        return ++departmentId;
    }
}
