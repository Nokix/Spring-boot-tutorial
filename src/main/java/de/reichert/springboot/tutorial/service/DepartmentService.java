package de.reichert.springboot.tutorial.service;

import de.reichert.springboot.tutorial.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Optional<Department> fetchDepartmentById(Long id);

    boolean deleteDepartmentById(Long id);

    Optional<Department> fetchDepartmentByName(String name);
}
