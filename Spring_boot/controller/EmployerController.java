package com.happyapp.controller;

import com.happyapp.service.EmployerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/happy-app/employers")
public class EmployerController {

    private EmployerService employerService = new EmployerService();


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployerById(@PathVariable("id") int id) {

        return employerService.getEmployerById(id);
    }

    @RequestMapping(value = "/{id}/company", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployerCompany(@PathVariable("id") int id) {

        return employerService.getEmployerCompany(id);
    }

    @RequestMapping(value = "/{id}/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployerEmployees(@PathVariable("id") int id) {

        return employerService.getEmployerEmployees(id);
    }

    @RequestMapping(value = "/{id}/questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployerQuestions(@PathVariable("id") int id) {

        return employerService.getEmployerQuestions(id);
    }

    @RequestMapping(value = "/{id}/answers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployerAnswer(@PathVariable("id") int id) {

        return employerService.getEmployerAnswer(id);
    }

    @RequestMapping(value = "/{id}/add-question/{value}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertQuestion(@PathVariable("id") int id, @PathVariable("value") String value) {

        employerService.insertQuestion(id, value);
    }
}
