package com.joyonta.springboot.tutorial.service;

import com.joyonta.springboot.tutorial.entity.Department;
import com.joyonta.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
