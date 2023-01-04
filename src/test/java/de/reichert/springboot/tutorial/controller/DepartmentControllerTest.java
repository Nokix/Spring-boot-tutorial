package de.reichert.springboot.tutorial.controller;

import de.reichert.springboot.tutorial.entity.Department;
import de.reichert.springboot.tutorial.error.DepartmentNotFoundException;
import de.reichert.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().name("IT")
                .address("Haus 11").id(1L).code("TT-000").build();
    }

    @Test
    void saveDepartment() throws Exception {
        // No id set.
        Department inputDepartment = Department.builder().name("IT")
                .address("Haus 11").code("TT-000").build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"IT\",\"address\":\"Haus 11\",\"code\":\"TT-000\"}");

        mockMvc.perform(post).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get("/qdepartment/1")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(get)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(department.getName()));
    }
}
