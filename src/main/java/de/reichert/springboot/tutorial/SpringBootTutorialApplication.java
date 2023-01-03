package de.reichert.springboot.tutorial;

import de.reichert.springboot.tutorial.entity.Department;
import de.reichert.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootTutorialApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTutorialApplication.class, args);

        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);

        Department department0 = Department.builder().name("Vertrieb").address("Haus 11").code("123").build();
        System.out.println(department0);

        department0 = departmentRepository.save(department0);
        System.out.println(department0);


    }

}
