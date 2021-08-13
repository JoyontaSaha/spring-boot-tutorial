package com.joyonta.springboot.tutorial.service;

import com.joyonta.springboot.tutorial.entity.Department;
import com.joyonta.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment (Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList () {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department dbDepartment = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department) && !dbDepartment.getDepartmentName().equalsIgnoreCase("")) {
            dbDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department) && !dbDepartment.getDepartmentAddress().equalsIgnoreCase("")) {
            dbDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department) && !dbDepartment.getDepartmentCode().equalsIgnoreCase("")) {
            dbDepartment.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(dbDepartment);
    }
}
