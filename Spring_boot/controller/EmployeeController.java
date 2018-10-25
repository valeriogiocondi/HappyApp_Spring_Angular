package com.happyapp.controller;

import com.happyapp.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/happy-app/employees")
public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployeeById(@PathVariable("id") int id) {

        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/{id}/company", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployeeCompany(@PathVariable("id") int id) {

        return employeeService.getEmployeeCompany(id);
    }

    @RequestMapping(value = "/{id}/questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployeeQuestions(@PathVariable("id") int id) {

//        System.out.println(id);

        return employeeService.getEmployeeQuestions(id);
    }

    @RequestMapping(value = "/{id}/answers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployeeAnswer(@PathVariable("id") int id) {

        return employeeService.getEmployeeAnswer(id);
    }
}
