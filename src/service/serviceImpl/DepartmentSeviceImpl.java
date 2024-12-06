package service.serviceImpl;

import dao.DepartmentDao;
import dao.GenericDao;
import dao.daouImpl.DepartmentDaoImpl;
import models.Department;
import service.DepartmentService;
import service.GenericService;

import java.util.List;

public class DepartmentSeviceImpl implements DepartmentService, GenericService<Department> {
    DepartmentDao departmentDao = new DepartmentDaoImpl();
    GenericDao genericDao = new DepartmentDaoImpl();
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return departmentDao.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }

    @Override
    public String add(Long hospitalId, Department department) {
        return genericDao.add(hospitalId,department);
    }

    @Override
    public void removeById(Long id) {
        genericDao.removeById(id);
    }

    @Override
    public String updateById(Long id) {
        return genericDao.updateById(id);
    }
}
