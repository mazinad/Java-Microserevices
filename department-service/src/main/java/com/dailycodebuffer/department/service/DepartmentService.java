package com.dailycodebuffer.department.service;

import com.dailycodebuffer.department.model.Department;
import com.dailycodebuffer.department.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    Logger logger = LoggerFactory.getLogger(DepartmentService.class);
    public Department saveDepartment(Department department) {
        logger.info("Saving department");
        return departmentRepository.save(department);
    }
    public Department getDepartment(Long id) {
        logger.info("Getting department");
        return departmentRepository.findByDepartmentId(id);
    }

    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long departmentId) {
      departmentRepository.deleteById(departmentId);
    }
}
