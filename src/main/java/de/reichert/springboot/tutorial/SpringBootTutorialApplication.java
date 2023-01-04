package de.reichert.springboot.tutorial;

import de.reichert.springboot.tutorial.entity.Department;
import de.reichert.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.*;

@SpringBootApplication
public class SpringBootTutorialApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTutorialApplication.class, args);

        //DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);

        //Department department0 = Department.builder().name("Vertrieb").address("Haus 11").code("123").build();
        //System.out.println(department0);

        //department0 = departmentRepository.save(department0);
        //System.out.println(department0);


    }

    @Bean
    public CommandLineRunner jdbcExample(DepartmentRepository departmentRepository) {
        return (args -> {

            Department department0 = Department.builder().name("Vertrieb").address("Haus 11").code("123").build();
            System.out.println(department0);
            department0 = departmentRepository.save(department0);


            String DB_URL = "jdbc:h2:file:./database/h2db;AUTO_SERVER=true";
            String USER = "sa";
            String PASS = "";
            String QUERY = "SELECT id, dep_name, address, code FROM dep";

            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
                // Extract data from result set
                while (rs.next()) {
                    // Retrieve by column name
                    System.out.print("ID: " + rs.getInt("id"));
                    System.out.print(", NAME: " + rs.getString("dep_name"));
                    System.out.print(", ADDRESS: " + rs.getString("address"));
                    System.out.println(", CODE: " + rs.getString("code"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } );
    }

}
