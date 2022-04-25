package com.dailycodebuffer.department.controller;

import com.dailycodebuffer.department.model.Department;
import com.dailycodebuffer.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "This is to add a new Department to Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Department Added to Db",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "NOt Available",
                    content = @Content)
    })
    @PostMapping("/save-department")
    public Department saveDepartment(@RequestBody Department department){
        logger.info("DepartmentController.saveDepartment()");
        return departmentService.saveDepartment(department);
    }
    @Operation(summary = "This is to fetch a Department from Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetched Department form Db",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "NOt Available",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId){
        logger.info("DepartmentController.getDepartment()");
        return departmentService.getDepartment(departmentId);
    }
    @Operation(summary = "This is to fetch All the Departments stored in Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetched All the Department form Db",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "NOt Available",
                    content = @Content)
    })
    @GetMapping("/allDepartments")
    public List<Department> fetchAllDepartments(){
        return departmentService.fetchAllDepartments();
    }
    @PostMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
    }
}
