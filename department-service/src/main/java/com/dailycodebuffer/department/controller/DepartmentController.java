package com.dailycodebuffer.department.controller;

import com.dailycodebuffer.department.model.Department;
import com.dailycodebuffer.department.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/save-department")
    public Department saveDepartment(@RequestBody Department department){
        logger.info("DepartmentController.saveDepartment()");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId){
        logger.info("DepartmentController.getDepartment()");
        return departmentService.getDepartment(departmentId);
    }
    @GetMapping("/allDepartments")
    public List<Department> fetchAllDepartments(){
        return departmentService.fetchAllDepartments();
    }
    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
    }
}
