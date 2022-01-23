package com.serviceDepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceDepartment.entity.Department;
import com.serviceDepartment.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @Operation(summary = "Insert a new department")
    @PostMapping("/")
    public Department post(@Parameter(description = "department id") @RequestBody Department department) {
        log.info("Post: {}", department);
        return service.save(department);
    }

    @Operation(summary = "Find a department by id")
    @GetMapping("/{id}")
    public Department get(@PathVariable Integer id) {
        log.info("Get: {}", id);
        return service.getOne(id);
    }

    @Operation(summary = "Find all departments")
    @GetMapping("")
    public List<Department> get() {
        log.info("Get");
        return service.findAll();
    }

}
