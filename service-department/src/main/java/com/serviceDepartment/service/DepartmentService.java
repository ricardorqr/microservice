package com.serviceDepartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDepartment.entity.Department;
import com.serviceDepartment.repository.DepartmentRepository;
import com.serviceDepartment.service.validation.Result;
import com.serviceDepartment.service.validation.Validator;
import com.serviceDepartment.service.validation.department.DepartmentUniqueNameValidation;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department save(Department department) {
        log.info("Save: {}", department);

        Result result = new Validator<Department>(new DepartmentUniqueNameValidation(department, repository)).validate();

        if (result.isCorrect()) {
            return repository.save(department);
        }

        return null;
    }

    public Department getOne(Integer id) {
        log.info("getOne: {}", id);
        return repository.findById(id).orElse(null);
    }

    public List<Department> findAll() {
        return repository.findAll();
    }

}
