package de.reichert.springboot.tutorial.service;

import de.reichert.springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();
}
