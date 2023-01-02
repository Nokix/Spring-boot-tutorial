package de.reichert.springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller ist eine spezielle Component
//@RestController umfasst @Controller und @ResponseBody
@RestController
public class HelloController {

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld() {

        return "Hello World, everyone!";
    }
}



