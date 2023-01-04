package de.reichert.springboot.tutorial.service;

import de.reichert.springboot.tutorial.entity.Department;
import de.reichert.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().name("IT")
                .address("Haus 11").id(1L).code("TT-000").build();

        Mockito.when(departmentRepository.findByName("IT"))
                .thenReturn(Optional.of(department));
    }

    @Test
    @DisplayName("Get Data based on valid Department Name")
    void fetchDepartmentByName_valid() {
        String departmentName = "IT";
        Optional<Department> found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.get().getName());
    }
}

