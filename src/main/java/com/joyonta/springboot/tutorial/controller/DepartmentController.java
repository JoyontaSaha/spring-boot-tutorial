package com.joyonta.springboot.tutorial.controller;

import com.joyonta.springboot.tutorial.entity.Department;
import com.joyonta.springboot.tutorial.error.DepartmentNotFoundException;
import com.joyonta.springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/saveDepartment")
    public Department saveDepartment (@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment() of DepartmentController Class");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/fetchDepartmentList")
    public List<Department> fetchDepartmentList () {
        LOGGER.info("Inside fetchDepartmentList() of DepartmentController Class");
        return departmentService.fetchDepartmentList ();
    }

    @GetMapping("/fetchDepartmentById/{id}")
    public Department fetchDepartmentById (@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById (departmentId);
    }

    @DeleteMapping("/deleteDepartmentById/{id}")
    public String deleteDepartmentById (@PathVariable("id") Long departmentId) {
         departmentService.deleteDepartmentById (departmentId);
         return "Department deleted successfully";
    }

    @PutMapping("/updateDepartment/{id}")
    public Department saveDepartment (@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/fetchDepartmentByName/{name}")
    public Department fetchDepartmentByName (@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName (departmentName);
    }

}
