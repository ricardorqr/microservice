package com.serviceDepartment.service.validation.department;

import java.util.Set;
import java.util.stream.Collectors;

import com.serviceDepartment.entity.Department;
import com.serviceDepartment.repository.DepartmentRepository;
import com.serviceDepartment.service.validation.ValidationResult;
import com.serviceDepartment.service.validation.Validator;

public class DepartmentUniqueNameValidation extends Validator<Department> {

    private final DepartmentRepository departmentRepository;

    public DepartmentUniqueNameValidation(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ValidationResult validate(Department department) {
        Set<String> departments = departmentRepository.findByName(department.getName()).stream()
                .map(Department::getName)
                .collect(Collectors.toSet());

        if (departments.contains(department.getName())) {
            return ValidationResult.invalid("Department has the name " + department.getName());
        }
        return checkNext(department);
    }

}
