package com.happyapp.controller;

import com.happyapp.service.QuestionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/happy-app/questions")
public class QuestionController {

    private QuestionService questionService = new QuestionService();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getQuestionById(@PathVariable("id") int id) {

        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

//    @RequestMapping(value = "/{id}/{value}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    public void updateQuestion(@PathVariable("id") int id, @PathVariable("value") String value) {
//
//        questionService.updateQuestion(id, value);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteQuestion(@PathVariable("id") int id) {

        questionService.deleteQuestion(id);
    }
}
