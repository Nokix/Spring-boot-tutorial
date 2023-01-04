package de.reichert.springboot.tutorial.service;

import de.reichert.springboot.tutorial.entity.Department;
import de.reichert.springboot.tutorial.error.DepartmentNotFoundException;
import de.reichert.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
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
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isEmpty()) {
            throw new DepartmentNotFoundException("No Department with Id " + id);
        }
        return departmentOptional.get();
    }

    @Override
    public void deleteDepartmentById(Long id) throws DepartmentNotFoundException{
        if (!departmentRepository.existsById(id)) {
            throw new DepartmentNotFoundException("No Department with Id "+ id);
        }
        departmentRepository.deleteById(id);
    }

    @Override
    public Optional<Department> fetchDepartmentByName(String name) {
        System.out.println(name);
        return departmentRepository.findByName(name);
    }
}
