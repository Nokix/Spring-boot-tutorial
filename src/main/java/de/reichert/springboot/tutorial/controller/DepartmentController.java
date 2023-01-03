package de.reichert.springboot.tutorial.controller;

import de.reichert.springboot.tutorial.entity.Department;
import de.reichert.springboot.tutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable("id") Long id) {
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id) {
        boolean foundAndDeleted = departmentService.deleteDepartmentById(id);
        return foundAndDeleted ? "Deleted Department " + id + " successfully."
                : "No Department with " + id + " found.";
    }

    @GetMapping("/department/name/{name}")
    public Optional<Department> fetchDepartmentByName(@PathVariable("name") String name) {
        return departmentService.fetchDepartmentByName(name);
    }
}
