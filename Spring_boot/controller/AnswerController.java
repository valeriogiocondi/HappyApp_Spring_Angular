package com.happyapp.controller;

import com.happyapp.service.AnswerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/happy-app/answers")
public class AnswerController {

    private AnswerService answerService = new AnswerService();


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAnswerById(@PathVariable("id") int id) {

        return answerService.getAnswerById(id);
    }

    @RequestMapping(value = "/new/employee/{employee}/question/{question}/value/{value}", method = RequestMethod.POST)
    public void insertAnswer(@PathVariable("employee") int employee, @PathVariable("question") int question, @PathVariable("value") String value) {

        answerService.insertAnswer(employee, question, value);
    }

}
