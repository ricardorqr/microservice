package com.serviceDepartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serviceDepartment.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
