package de.reichert.springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller ist eine spezielle Component
//@RestController umfasst @Controller und @ResponseBody
@RestController
@PropertySource("classpath:welcome.properties")
public class HelloController {

    @Value("${welcome.message}")
    private String welcome;

    @GetMapping("/")
    public String helloWorld() {
        return welcome;
    }
}
