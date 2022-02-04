package com.serviceDepartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDepartment.entity.Department;
import com.serviceDepartment.repository.DepartmentRepository;
import com.serviceDepartment.service.validation.ValidationResult;
import com.serviceDepartment.service.validation.department.DepartmentUniqueNameValidation;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        log.info("Save: {}", department);

        ValidationResult result = new DepartmentUniqueNameValidation(departmentRepository).validate(department);

        if (result.isValid()) {
            return departmentRepository.save(department);
        }

        return null;
    }

    public Department getOne(Integer id) {
        log.info("getOne: {}", id);
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

}
