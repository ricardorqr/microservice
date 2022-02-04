package com.serviceDepartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import com.serviceDepartment.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    public List<Department> findByName(String name);

}
