package de.reichert.springboot.tutorial.controller;

import de.reichert.springboot.tutorial.entity.Department;
import de.reichert.springboot.tutorial.error.DepartmentNotFoundException;
import de.reichert.springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public List<Department> getAllDepartments() {
        LOGGER.info("Getting All Departments");
        return departmentService.getAllDepartments();
    }

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long id) {
        try {
            departmentService.deleteDepartmentById(id);
        } catch (DepartmentNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/department/name/{name}")
    public Optional<Department> fetchDepartmentByName(@PathVariable("name") String name) {
        return departmentService.fetchDepartmentByName(name);
    }
}
