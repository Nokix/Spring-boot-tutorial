package de.reichert.springboot.tutorial.service;

import de.reichert.springboot.tutorial.entity.Department;
import de.reichert.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id) throws DepartmentNotFoundException;

    Optional<Department> fetchDepartmentByName(String name);
}
