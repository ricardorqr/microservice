package com.serviceDepartment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDepartment.entity.Department;
import com.serviceDepartment.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department save(Department department) {
        log.info("Save: {}", department);
        return  repository.save(department);
    }

    public Department getOne(Integer id) {
        log.info("getOne: {}", id);
        return repository.findById(id).orElse(null);
    }

    public List<Department> findAll() {
        return repository.findAll();
    }
}
