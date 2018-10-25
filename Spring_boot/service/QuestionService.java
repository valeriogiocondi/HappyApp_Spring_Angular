package com.happyapp.service;

import com.happyapp.dao.QuestionDao;

public class QuestionService {

    private QuestionDao questionDao = new QuestionDao();


    public String getQuestionById(int id) {

        return this.questionDao.getQuestionById(id);
    }

//    public void updateQuestion(int id, String value) {
//
//        this.questionDao.updateQuestion(id, value);
//    }

    public void deleteQuestion(int id) {

        this.questionDao.deleteQuestion(id);
    }
}
