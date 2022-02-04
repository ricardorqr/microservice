package com.serviceDepartment.service.validation.department;

import java.util.Set;
import java.util.stream.Collectors;

import com.serviceDepartment.entity.Department;
import com.serviceDepartment.repository.DepartmentRepository;
import com.serviceDepartment.service.validation.IValidator;
import com.serviceDepartment.service.validation.Result;

public class DepartmentUniqueNameValidation implements IValidator<Department> {

    private Department department;
    private DepartmentRepository departmentRepository;

    public DepartmentUniqueNameValidation(Department department, DepartmentRepository departmentRepository) {
        this.department = department;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Result validate() {
        if (department != null) {
            Set<String> departments = departmentRepository.findByName(department.getName()).stream()
                    .map(Department::getName)
                    .collect(Collectors.toSet());
            if (departments.contains(department.getName())) {
                return new Result(false, "Department has the name " + department.getName());
            }
        }
        return new Result(true, "ok");
    }

}
