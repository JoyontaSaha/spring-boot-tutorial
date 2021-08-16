package com.joyonta.springboot.tutorial.service;

import com.joyonta.springboot.tutorial.entity.Department;
import com.joyonta.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = new Department().builder()
                .departmentName("IT")
                .departmentAddress("Kolkata")
                .departmentCode("IT-101")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }
}