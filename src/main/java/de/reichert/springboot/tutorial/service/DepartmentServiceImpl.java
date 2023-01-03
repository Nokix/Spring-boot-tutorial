package de.reichert.springboot.tutorial.service;

import de.reichert.springboot.tutorial.entity.Department;
import de.reichert.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> fetchDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        if (!departmentRepository.existsById(id)) return false;
        departmentRepository.deleteById(id);
        return true;
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department currentDepartment = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getName()) && !department.getName().isEmpty()) {
            currentDepartment.setName(department.getName());
        }

        //...

        return departmentRepository.save(currentDepartment);
    }
}
