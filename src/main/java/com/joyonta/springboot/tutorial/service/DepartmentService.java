package com.joyonta.springboot.tutorial.service;

import com.joyonta.springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment (Department department);

    List<Department> fetchDepartmentList ();
}
