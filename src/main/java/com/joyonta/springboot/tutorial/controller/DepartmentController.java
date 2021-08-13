package com.joyonta.springboot.tutorial.controller;

import com.joyonta.springboot.tutorial.entity.Department;
import com.joyonta.springboot.tutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public Department saveDepartment (@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/fetchDepartmentList")
    public List<Department> fetchDepartmentList () {
        return departmentService.fetchDepartmentList ();
    }

    @GetMapping("/fetchDepartmentById/{id}")
    public Department fetchDepartmentById (@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById (departmentId);
    }
}
